package cn.study.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.study.base.dao")
//添加事务注解
@EnableTransactionManagement
public class BaseApplication {

    /**
     * 该项目作为一个基本项目
     * 实现了mybatis的集成和配置,并可以自动生成POJO对象
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}
