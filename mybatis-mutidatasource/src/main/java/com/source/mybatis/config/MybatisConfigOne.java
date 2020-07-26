package com.source.mybatis.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.source.mybatis.mapper1" ,sqlSessionTemplateRef="sqlSessionTemplateone"
        ,sqlSessionFactoryRef="sessionFactoryone")
public class MybatisConfigOne {
    @Resource(name="dsOne")
    DataSource dsOne;

    @Bean
    SqlSessionFactory sessionFactoryone(){
        SqlSessionFactory sessionFactory=null;
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dsOne);
        try {
            sessionFactory= bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
    @Bean
    SqlSessionTemplate  sqlSessionTemplateone(){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sessionFactoryone());
        return sqlSessionTemplate;

    }



}
