package com.norteksoft.demo.service.impl;

import com.norteksoft.demo.entity.Users;
import com.norteksoft.demo.repossitory.UsersRepository;
import com.norteksoft.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)//遇到异常回滚
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Optional<Users> get(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void delete(Users users) {
        usersRepository.delete(users);
    }

    @Override
    public List<Users> find() {
        return usersRepository.findAll();
    }
}
