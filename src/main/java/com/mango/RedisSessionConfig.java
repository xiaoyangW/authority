package com.mango;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Aaron on 2017-07-31.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
public class RedisSessionConfig {

}
