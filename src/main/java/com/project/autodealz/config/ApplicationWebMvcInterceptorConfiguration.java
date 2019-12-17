package com.project.autodealz.config;

import com.project.autodealz.web.interseptors.FaviconInterceptor;
import com.project.autodealz.web.interseptors.WelcomingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationWebMvcInterceptorConfiguration implements WebMvcConfigurer {
    private final WelcomingInterceptor welcomingInterceptor;
    private final FaviconInterceptor faviconInterceptor;

    @Autowired
    public ApplicationWebMvcInterceptorConfiguration(WelcomingInterceptor welcomingInterceptor, FaviconInterceptor faviconInterceptor) {
        this.welcomingInterceptor = welcomingInterceptor;
        this.faviconInterceptor = faviconInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.welcomingInterceptor);
        registry.addInterceptor(this.faviconInterceptor);
    }
}
