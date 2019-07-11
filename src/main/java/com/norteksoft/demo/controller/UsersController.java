package com.norteksoft.demo.controller;

import com.norteksoft.demo.entity.Users;
import com.norteksoft.demo.exception.ResourceNotFoundException;
import com.norteksoft.demo.service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 创建数据
     * @param users
     * @return
     */
    @PostMapping("/user/")
    public Users createVehicle(@RequestBody Users users) {
            return usersService.save(users);
    }

    /**
     * 通过ID查询数据
     * @param usersId
     * @return
     */
    @GetMapping("/users/{usersId}")
    public Users findUsers(@PathVariable Long usersId){
        return usersService.get(usersId).orElseThrow(()->new ResourceNotFoundException("usersId:"+usersId + "not found"));
    }
    /**
     * 通过name查询数据
     * @param usersId
     * @return
     *//*
    @GetMapping("/users/{usersName}")
    public Users findUsersByName(@PathVariable Long usersName){
        return usersService.get(usersName).orElseThrow(()->new ResourceNotFoundException("usersName:"+usersName + "not found"));
    }*/

    /**
     * 修改数据
     * @param usersId
     * @param users
     * @return
     */
    @PutMapping("/users/{usersId}")
    public Users updateUsers(@PathVariable Long usersId, @RequestBody Users users){
        return usersService.get(usersId).map(usersIdDB -> {
            BeanUtils.copyProperties(users, usersIdDB);
            return usersService.save(usersIdDB);
        }).orElseThrow(()->new ResourceNotFoundException("usersId:"+usersId + "not found"));
    }

    /**
     * 根据ID删除
     * @param usersId
     * @return
     */
    @DeleteMapping("/users/{usersId}")
    public ResponseEntity<?> deleteUsers(@PathVariable Long usersId){
        return usersService.get(usersId).map(users -> {
            usersService.delete(users);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("usersId:"+usersId + "not found"));
    }
    /**
     * 查询数据
     * @param usersId
     * @return
     */
    @GetMapping("/users")
    public List<Users> findAll(){
        return usersService.find();
    }

   /* @GetMapping("/users/{usersName}")
    public List<Users>  findByName(@PathVariable String usersName) {
        return usersService.
    }*/
}
