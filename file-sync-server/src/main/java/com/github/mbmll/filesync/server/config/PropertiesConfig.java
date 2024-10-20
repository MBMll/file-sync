package com.github.mbmll.filesync.server.config;

import com.github.mbmll.filesync.server.properties.ConfigProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {
    @Bean
    @ConfigurationProperties(prefix = "filesync")
    public ConfigProperties configProperties() {
        return new ConfigProperties();
    }

}
