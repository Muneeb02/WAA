package com.example.lab4.config;



import com.example.lab4.service.Impl.UsersServiceImpl;
import com.example.lab4.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public UsersService usersService(){
        return new UsersServiceImpl();
    }

}
