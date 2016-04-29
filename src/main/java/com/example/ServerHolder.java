package com.example;

import com.example.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by kimyongyeon on 2016-04-26.
 */
//@Component
//@ConfigurationProperties(locations = {"classpath:servers.yml", "classpath:servers_list.yml"})
@Configuration
@EnableWebMvc
public class ServerHolder extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
        //super.addInterceptors(registry);
    }

//    public List<Map<String, String>> servers = new ArrayList<Map<String, String>>();
//
//    public List<Map<String, String>> getServers() {
//        return servers;
//    }
//    public Map<String, Map<String, String>> servers = new HashMap<String, Map<String, String>>();
//
//    public Map<String, Map<String, String>> getServers() {
//        return servers;
//    }

}
