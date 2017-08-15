package com.mango.provider;

import com.mango.domain.User;

/**
 * Created by Aaron on 2017-08-01.
 */
public class UserProvider {
    public String getUserById(Long id){
        String sql = "select id,userName,passWord from user where id = " + id + ";";
        return sql;
    }
    public String updateUser(User user){
        String sql = "update user set passWord = '" + user.getPassWord() + "';";
        return sql;
    }
    public String getUserByNameAndPassword(String name, String password){
        String sql = "select id,userName,passWord from user where userName = '" + name + "' and passWord = '" + password + "';";
        return sql;
    }
}
