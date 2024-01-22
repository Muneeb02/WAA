package com.example.lab4.service.Impl;

import com.example.lab4.dto.PostDto;
import com.example.lab4.model.Post;
import com.example.lab4.repo.PostRepository;
import com.example.lab4.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

   private final PostRepository postRepository;
   private final ModelMapper modelMapper;
    @Override
    public PostDto getPostById(long id) {

        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            Post post1 = post.get();
           //return new PostDto(post1.getId(), post1.getTitle(), post1.getContent(),post1.getAuthor());
            return modelMapper.map(post1, PostDto.class);
        }else{
            throw new RuntimeException("post not found");
        }
    }

    @Override
    public List<PostDto> getAllPost() {
        return postRepository.findAll().stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto createNewPost(PostDto postDTO) {
        Post post = postRepository.save(modelMapper.map(postDTO, Post.class));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDTO) {
        Optional<Post> post = postRepository.findById(id);
        if ((post.isPresent())){
            post.get().setContent(postDTO.getContent());
            postRepository.save(post.get());
            return postDTO;
        }
        throw new RuntimeException("Update unsuccessful");
    }

//    public PostDto updatePost1(long id, PostDto postDTO) {
//        Optional<Post> post = postRepository.findById(id);
//        if ((post.isPresent())){
//            //post.get().setContent(postDTO.getContent());
//            Post post1 = modelMapper.map(postDTO, Post.class);
//            post1.setId(post.get().getId());
//            postRepository.save(post1);
//        }
//
//        return postRepository.save(id, postDTO);
//    }

    @Override
    public boolean deletePostById(long id) {
        Optional<Post> post = postRepository.findById(id);
        if ((post.isPresent())){
            postRepository.delete(post.get());
            return true;
        }
        throw new RuntimeException("cant find post");


    }
}
