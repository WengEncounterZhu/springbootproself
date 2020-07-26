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
@MapperScan(basePackages = "com.source.mybatis.mapper3" ,sqlSessionTemplateRef="sqlSessionTemplatethree"
        ,sqlSessionFactoryRef="sessionFactorythree")
public class MybatisConfigThree {

    @Resource(name="dsTh")
    DataSource dsThree;

    @Bean
    SqlSessionFactory sessionFactorythree(){
        SqlSessionFactory sessionFactory=null;
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dsThree);
        try {
            sessionFactory= bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
    @Bean
    SqlSessionTemplate sqlSessionTemplatethree(){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sessionFactorythree());
        return sqlSessionTemplate;

    }



}
