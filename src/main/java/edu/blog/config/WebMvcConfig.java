package edu.blog.config;


import edu.blog.core.interceptor.ConsoleInterceptor;
import edu.blog.core.interceptor.LoginInterceptor;
import edu.blog.core.interceptor.ParamInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc 配置
 *
 * @author 执笔
 * @date 2019/4/2 10:58
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ConsoleInterceptor consoleInterceptor;
    @Autowired
    private LoginInterceptor   loginInterceptor;
    @Autowired
    private ParamInterceptor   paramInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(consoleInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login", "/admin/logout");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/**");

        registry.addInterceptor(paramInterceptor)
                .addPathPatterns("/**");
    }
}
