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
@MapperScan(basePackages = "com.source.mybatis.mapper2" ,sqlSessionTemplateRef="sqlSessionTemplatetwo"
        ,sqlSessionFactoryRef="sessionFactorytwo")
public class MybatisConfigTwo {

    @Resource(name="dsTwo")
    DataSource dsTwo;

    @Bean
    SqlSessionFactory sessionFactorytwo(){
        SqlSessionFactory sessionFactory=null;
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dsTwo);
        try {
            sessionFactory= bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
    @Bean
    SqlSessionTemplate sqlSessionTemplatetwo(){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sessionFactorytwo());
        return sqlSessionTemplate;

    }



}
