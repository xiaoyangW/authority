package com.mango.dao;

import com.mango.domain.User;
import com.mango.provider.UserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * Created by Aaron on 2017-08-01.
 */
@Mapper
public interface IUserDao {

    @SelectProvider(type = UserProvider.class, method = "getUserById")
    User getUserById(Long id);
    @SelectProvider(type = UserProvider.class, method = "getUserByNameAndPassword")
    User getUserByNameAndPassword(String name, String password);
    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    User updateUser(User user);
}
