package com.example.lab4.service;


import com.example.lab4.dto.PostDto;
import com.example.lab4.dto.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<UsersDto> getAllUsers();
    UsersDto getUsersById(long id);
    UsersDto createNewUser(UsersDto usersDto);
    List<PostDto> getUserPosts(Long id);

    List<UsersDto> getUserWithMorePosts(int n);

    String delteUserById(long id);


}
