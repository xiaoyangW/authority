package com.mango.service;

import com.mango.domain.User;

/**
 * Created by Aaron on 2017-08-01.
 */
public interface IUserService {
    User getUserById(Long id);
    User getUserByNameAndPassword(String namei, String password);
    User updateUser(User user);
}
