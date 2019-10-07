package com.example.demo;

import com.example.demo.repository.FriendsRepository;
import com.example.demo.repository.FriendshipsRepository;
import com.example.demo.service.FriendsService;
import com.example.demo.service.FriendshipsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Application extends SpringBootServletInitializer {

    @Bean
    public FriendsService FriendsService(FriendsRepository friendsRepository){
        return new FriendsService(friendsRepository);
    }

    @Bean
    public FriendshipsService FriendshipsService(FriendshipsRepository friendshipsRepository){
        return new FriendshipsService(friendshipsRepository);
    }

    @Bean
    public FriendsController FriendsController(){
        return new FriendsController();
    }

    @Bean
    public Friends Friends(){
        return new Friends();
    }

    @Bean
    public Friendships Friendships(){
        return new Friendships();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}