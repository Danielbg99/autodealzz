package com.project.autodealz.config;

import com.project.autodealz.web.interseptors.FaviconInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationWebMvcInterceptorConfiguration implements WebMvcConfigurer {
//    private final TitleInterceptor titleInterceptor;
    private final FaviconInterceptor faviconInterceptor;

    @Autowired
    public ApplicationWebMvcInterceptorConfiguration(FaviconInterceptor faviconInterceptor) {
        this.faviconInterceptor = faviconInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     //   registry.addInterceptor(this.titleInterceptor);
        registry.addInterceptor(this.faviconInterceptor);
    }
}
