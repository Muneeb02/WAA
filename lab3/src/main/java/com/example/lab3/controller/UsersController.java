package com.example.lab3.controller;


import com.example.lab3.dto.PostDto;
import com.example.lab3.dto.UsersDto;
import com.example.lab3.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers(@RequestParam( value = "name", required = false) String name){
        List<UsersDto> users = usersService.getAllUsers();
        System.out.println(name);
        return ResponseEntity.ok((users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> getUserByID(@PathVariable long id){
        UsersDto users = usersService.getUsersById(id);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public  ResponseEntity<UsersDto> createNewUser(@RequestBody UsersDto usersDto){
        UsersDto usersDto1 = usersService.createNewUser(usersDto);
        return ResponseEntity.ok(usersDto1);
    }

    @GetMapping("/{id}/posts/")
    public ResponseEntity<List<PostDto>> getAllPostFromUsers(@PathVariable long id){
        List<PostDto> postDto = usersService.getUserPosts(id);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping("/postMoreThan/{n}")
    public ResponseEntity<List<UsersDto>> getUserMorePosts(@PathVariable int n){
         return ResponseEntity.ok(usersService.getUserWithMorePosts(n));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserbyId(@PathVariable long id){
           String s = usersService.delteUserById(id);
           return ResponseEntity.ok(s);
    }

}
