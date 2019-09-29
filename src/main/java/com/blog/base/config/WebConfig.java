package com.blog.base.config;
import com.blog.base.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Autowired
    private LoginInterceptor loginInterceptor;
    //addPathPatterns("/**")拦截所有的请求
    //excludePathPatterns("/login", "/register")除去登录和注册请求

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login", "/admin/register",
                "/admin/common/kaptcha").excludePathPatterns("/admin/plugins/**").excludePathPatterns("/admin/assets/**");
    }
    //配置静态资源的，比如html，js，css，等等

/*    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
        //.setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic())
        ;
    }*/
}
