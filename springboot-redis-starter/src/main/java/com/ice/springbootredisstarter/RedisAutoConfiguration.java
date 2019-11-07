package com.ice.springbootredisstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @ClassName RedisAutoConfiguration
 * @Description TODO
 * @Author liubin
 * @Date 2019/11/6 11:06 AM
 **/
//开启配置
@Configuration
//加载条件：存在Jedis类时生效
@ConditionalOnClass(Jedis.class)
//指定配置属性
@EnableConfigurationProperties(RedisProperties.class)
//存在对应属性时，才会初始化该配置类
@ConditionalOnProperty(
        //配置前缀
        prefix = "redis",
        //开启
        value = "enabled",
        //配置缺失检查
        matchIfMissing = true)
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(RedisProperties redisProperties){
        return new Jedis(redisProperties.getHost(),redisProperties.getPort());
    }
}