package com.ice.springbootredisstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName RedisProperties
 * @Description TODO
 * @Author liubin
 * @Date 2019/11/6 11:07 AM
 **/
//配置类（这里需要指定配置的前缀）
@ConfigurationProperties("redis")
public class RedisProperties {

    private String host;

    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
