package edu.miu.demoinclass2.service;

import edu.miu.demoinclass2.model.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto getPostById(long id);
    List<PostDto> getAllPost();
    PostDto createNewPost(PostDto postDTO);
    PostDto updatePost(long id,PostDto postDTO);
    boolean deletePostById(long id);

}
