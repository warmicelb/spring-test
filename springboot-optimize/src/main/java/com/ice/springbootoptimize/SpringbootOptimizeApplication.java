package com.ice.springbootoptimize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * springboot优化：
 * 1.springboot默认扫描启动类所在包的所有类，如果不需要，可以指定扫描特定的包@EnableAutoConfiguration,@ComponentScan(basePackages = "com.ice.springbootoptimize.controller")
 *  2.@EnableAutoConfiguration 会导入AutoConfigurationImportSelector，加载所有的 spring.factories中的配置进行扫描。这里可以指定特定的配置进行导入。
 */
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.ice.springbootoptimize.controller")
//这里指定加载特定的配置类（这里只写了一个类，并不能正常运行）
//@Import({DispatcherServletAutoConfiguration.class})
public class SpringbootOptimizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOptimizeApplication.class, args);
    }

}
