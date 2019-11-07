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
 * @ClassName RbacDatasourceConfiguration
 * @Description TODO
 * @Author liubin
 * @Date 2019/11/6 7:40 PM
 **/
@Configuration
@MapperScan(basePackages = "com.ice.datasource.dao.orders",sqlSessionFactoryRef = "rbacSqlSessionFactory")
public class RbacDatasourceConfiguration {

    @Bean
    public DataSource rbacDatasource(RbacDbConfig config){
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setUrl(config.getJdbcUrl());
        mysqlXADataSource.setPassword(config.getPassword());
        mysqlXADataSource.setUser(config.getUsername());

        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("rbacDatasource");
        return atomikosDataSourceBean;
    }

    @Bean
    public SqlSessionFactory rbacSqlSessionFactory(@Qualifier("rbacDatasource") DataSource rbacDatasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(rbacDatasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/orders/*.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate rbacSqlSessionTemplate(
            @Qualifier("rbacSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
