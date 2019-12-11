package cn.study.base.config;

import cn.study.base.filter.MyFilter;
import cn.study.base.intercepter.LoginIntercepter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Filter;

/**
 * @ClassName: MyWebConfig
 * @author: 10724
 * @date: Created in 2019/11/8
 * @Description: 配置拦截器和filter，一般springboot的项目不适用，适用于一些老框架转换成Springboot中
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                //添加的拦截路径
                .addPathPatterns("/**")
                //添加不拦截的路径
                .excludePathPatterns("/login", "/registry");
    }

    /**
     * 注册一个自定义的过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    /**
     * 注册一个编码过滤器
     * 需要在yml中配置spring.http.encoding.enable=false才生效
     *
     * @return
     */
    public FilterRegistrationBean characterFilterRegistrationBean() {
        //创建一个字符过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        //添加到mvc中
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
