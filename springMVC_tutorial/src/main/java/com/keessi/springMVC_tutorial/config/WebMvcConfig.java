package com.keessi.springMVC_tutorial.config;

import com.keessi.springMVC_tutorial.interceptor.AdminInterceptor;
import com.keessi.springMVC_tutorial.interceptor.LogInterceptor;
import com.keessi.springMVC_tutorial.interceptor.OldLoginInterceptor;
import com.keessi.springMVC_tutorial.interceptor.UrlLocaleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resource/css/").setCachePeriod(300);
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/resource/img/").setCachePeriod(300);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(300);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
        registry.addInterceptor(new OldLoginInterceptor())
                .addPathPatterns("/admin/oldLogin");
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/*");
//        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
//        localeInterceptor.setParamName("lang");
        UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
        registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/zh/*");
    }
}
