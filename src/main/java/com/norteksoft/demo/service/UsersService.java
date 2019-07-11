package com.norteksoft.demo.service;

import com.norteksoft.demo.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users save(Users users);
    Optional<Users> get(Long id);
    void delete(Long id);
    void delete(Users users);
    List<Users> find();

}
