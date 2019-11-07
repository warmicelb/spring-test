package com.ice.datasource.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @ClassName ShiroDatasourceConfiguration
 * @Description TODO
 * @Author liubin
 * @Date 2019/11/6 7:40 PM
 **/
@Configuration
@MapperScan(basePackages = "com.ice.datasource.dao.users",sqlSessionFactoryRef = "shiroSqlSessionFactory")
public class ShiroDatasourceConfiguration {

    @Bean
    //这里一定要将一个设置为默认的数据源
    @Primary
    public DataSource shiroDatasource(ShiroDbConfig config){
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setUrl(config.getJdbcUrl());
        mysqlXADataSource.setPassword(config.getPassword());
        mysqlXADataSource.setUser(config.getUsername());

        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("shiroDatasource");
        return atomikosDataSourceBean;
    }

    @Bean
    public SqlSessionFactory shiroSqlSessionFactory(@Qualifier("shiroDatasource") DataSource shiroDatasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(shiroDatasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/users/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate shiroSqlSessionTemplate(
            @Qualifier("shiroSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
