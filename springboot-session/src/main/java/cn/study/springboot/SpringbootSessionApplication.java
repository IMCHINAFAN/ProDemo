package cn.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class SpringbootSessionApplication {

    /**
     * 1.添加依赖
     * 2.配置yml文件
     * 3.在启动类中添加@EnableRedisHttpSession注解
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSessionApplication.class, args);
    }

}
