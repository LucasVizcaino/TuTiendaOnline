package com.tutiendaonline.user.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {

    private String secretKey;

    public String getSecretKey(){
        return secretKey;
    }

    public void setSecretKey(String secretKey){
        this.secretKey = secretKey;
    }
}
