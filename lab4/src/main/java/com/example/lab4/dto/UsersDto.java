package com.example.lab4.dto;


import com.example.lab4.model.Post;
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
