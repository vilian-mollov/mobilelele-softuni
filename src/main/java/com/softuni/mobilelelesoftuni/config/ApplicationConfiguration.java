package com.softuni.mobilelelesoftuni.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public Gson gson(){
//        return new GsonBuilder().setPrettyPrinting().create();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
//    }



}
