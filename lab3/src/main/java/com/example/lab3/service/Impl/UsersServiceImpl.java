package com.example.lab3.service.Impl;



import com.example.lab3.dto.PostDto;
import com.example.lab3.dto.UsersDto;
import com.example.lab3.model.Post;
import com.example.lab3.model.Users;
import com.example.lab3.repo.UsersRepository;
import com.example.lab3.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private  ModelMapper modelMapper;
    @Override
    public List<UsersDto> getAllUsers() {

        return usersRepository.findAll()
                .stream().map(users -> modelMapper.map(users, UsersDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getUsersById(long id) {
        Optional<Users> users = usersRepository.findById(id);
        if(users.isPresent()) {
            Users users1 = users.get();
            return modelMapper.map(users1, UsersDto.class);
        }else {
            throw new RuntimeException("user not found");
        }
    }

    @Override
    public UsersDto createNewUser(UsersDto usersDto) {
        Users users = usersRepository.save(modelMapper.map(usersDto, Users.class));
        return modelMapper.map(users, UsersDto.class);
    }

    @Override
    public List<PostDto> getUserPosts(Long id) {
        //get the user
        // user.posts
        Optional<Users> users = usersRepository.findById(id);
        if (users.isPresent()) {
            Users user = users.get();
            List<Post> s = user.getPosts();

            return s.stream().map(post -> modelMapper.map(s, PostDto.class)).collect(Collectors.toList());
        }
        throw new RuntimeException("User not exist");
    }

    @Override
    public List<UsersDto> getUserWithMorePosts(int n) {
        List<Users> user = usersRepository.listOfUsersMoreThanOnePosts(n);
        return user.stream().map(users -> modelMapper.map(users,UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public String delteUserById(long id) {
        Optional<Users> users = usersRepository.findById(id);
        if (users.isPresent()){

           usersRepository.deleteById(id);
            return "Deleted successfully";
        }
        throw new RuntimeException("User not found!");
    }


}
