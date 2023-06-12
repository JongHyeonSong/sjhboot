package com.example.sjhboot.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mariadb.jdbc.Driver;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisConfig
 */

@Configuration
public class MybatisConfig {

//	   String url = "jdbc:mariadb://localhost:3306/newlec?";
//       String userName = "root";
//       String password = "whdgus159!";
       
	@Autowired
	ApplicationContext applicationContext;
	
	
	
    @Bean
    public DataSource dataSource() {

    	
     	System.out.println(12314);
        DataSourceBuilder dsb = DataSourceBuilder.create();

        dsb.url("jdbc:mariadb://localhost:3306/newlec?");
        dsb.username("root");
        dsb.password("whdgus159!");
        dsb.driverClassName(Driver.class.getName());
        
        DataSource dataSource = dsb.build();

        return dataSource;

    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    	sqlSessionFactoryBean.setDataSource(dataSource());
    	sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mymy-config.xml"));
    	sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
    	
    	return sqlSessionFactoryBean.getObject();
    }	
    
    @Bean
    public SqlSession sqlSession() throws Exception {
    	return new SqlSessionTemplate(sqlSessionFactory());
    }
    
    
    
//    @Bean
//    public SqlSession sqls() throws Exception {
//    	SqlSessionFactoryBean sqlFactory = new SqlSessionFactoryBean();
//    	sqlFactory.setDataSource(dataSource());
//    	sqlFactory.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
//    	sqlFactory.setConfigLocation(applicationContext.getResource("classpath:/mymy-config.xml"));
//    	
//    	SqlSessionFactory ssF = sqlFactory.getObject();
//    	
//    	SqlSessionTemplate sse =new SqlSessionTemplate(ssF);
//    	
//    	SqlSession slsl = sse;
//    	
//    	return slsl;
//    	
//    }
}