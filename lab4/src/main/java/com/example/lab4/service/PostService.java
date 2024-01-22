package com.example.lab4.service;



import com.example.lab4.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto getPostById(long id);
    List<PostDto> getAllPost();
    PostDto createNewPost(PostDto postDTO);
    PostDto updatePost(long id,PostDto postDTO);
    boolean deletePostById(long id);

}
