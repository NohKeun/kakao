package com.kakao.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Slf4j
@Configuration
public class WebConfig {
    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView ov = new MappingJackson2JsonView();
        ov.setContentType("application/json;charset=UTF-8");
        ov.setObjectMapper(new ObjectMapper());

        return ov;
    }
}