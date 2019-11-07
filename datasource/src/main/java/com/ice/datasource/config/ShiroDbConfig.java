package com.ice.datasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ShiroDbConfig
 * @Description TODO
 * @Author liubin
 * @Date 2019/11/6 7:37 PM
 **/
@ConfigurationProperties(prefix = "spring.datasource.spring")
@Component
@Data
public class ShiroDbConfig {

    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
}
