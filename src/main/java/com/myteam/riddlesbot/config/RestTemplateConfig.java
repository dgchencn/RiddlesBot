package com.myteam.riddlesbot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /**
     * 没有实例化RestTemplate时，初始化RestTemplate
     * @return
     */
    @ConditionalOnMissingBean(RestTemplate.class)
    /**
     * RestTemplate实例交给spring管理
     */
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}