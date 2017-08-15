package com.mango.service.impl;

import com.mango.AuthorityApplication;
import com.mango.dao.IUserDao;
import com.mango.domain.User;
import com.mango.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aaron on 2017-08-01.
 */
@Service
@Transactional
@CacheConfig(cacheNames = {"userCache"})
public class UserServiceImpl implements IUserService {
    private static Logger logger = Logger.getLogger(AuthorityApplication.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User getUserById(Long id) {
        String key = "user_" + id;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();

        //缓存是否存在
        boolean haskey = redisTemplate.hasKey(key);
        User user;
        if(haskey){
            user = operations.get(key);
            logger.info("UserServiceImpl.getUserById() : 从缓存中获取了用户 >> " + user.toString());
            return user;
        }
        user = userDao.getUserById(id);
        if(user != null) {
            //插入缓存
            operations.set(key, user, 30, TimeUnit.MINUTES);
            logger.info("UserServiceImpl.getUserById() : 缓存用户  >> " + user.toString());
        }
        return user;
    }

    @Override
    @Cacheable(value = "userLogin")
    public User getUserByNameAndPassword(String name, String password) {
        /*// 缓存的key
        String key = "user_" + name;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();

        //缓存是否存在
        boolean haskey = redisTemplate.hasKey(key);
        User user;
        if(haskey){
            user = operations.get(key);
            logger.info("UserServiceImpl.getUserByNameAndPassword() : 从缓存中获取了用户  >> " + user.toString());
            return user;
        }
        user = userDao.getUserByNameAndPassword(name, password);
        if (user != null) {
            //插入缓存
            operations.set(key, user, 30, TimeUnit.MINUTES);
            logger.info("UserServiceImpl.getUserByNameAndPassword() : 缓存用户 >> " + user.toString());
        }*/
        User user = userDao.getUserByNameAndPassword(name, password);
        return user;
    }

    @Override
    public User updateUser(User user) {
        user = userDao.updateUser(user);
        if (user.getId() != null) {
            // 缓存存在，删除缓存
            String key = "user_" + user.getId();
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                logger.info("UserServiceImpl.updateUser() : 从缓存中删除用户  >> " + user.toString());
                ValueOperations<String, User> operations = redisTemplate.opsForValue();
                operations.set(key, user, 30, TimeUnit.MINUTES);
            }
        }
        return user;
    }
}
