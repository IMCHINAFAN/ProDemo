package cn.study.fileupload.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName: WebMvcConfig
 * @author: 10724
 * @date: Created in 2019/11/8
 * @Description:
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    //文件真实路径
    private static final String PATH = "file:D:/fileupload/";

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler映射的资源路径，即前端访问时的路径
        registry.addResourceHandler("/file/virtual/**")
                //addResourceLocations本地的实际路径
                .addResourceLocations(PATH);
        super.addResourceHandlers(registry);
    }
}
