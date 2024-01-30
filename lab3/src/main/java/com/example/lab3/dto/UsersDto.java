package com.example.lab3.dto;


import com.example.lab3.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    String name;
    List<PostDto> posts;

}
