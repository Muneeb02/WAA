package com.example.lab3.service.Impl;

import com.example.lab3.dto.CommentsDto;
import com.example.lab3.model.Comments;
import com.example.lab3.model.Post;
import com.example.lab3.repo.PostRepository;
import com.example.lab3.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

private final PostRepository postRepository;
private final ModelMapper modelMapper;
    @Override
    public CommentsDto createCommentByPostId(long id, CommentsDto commentsDto) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Comments comments = modelMapper.map(commentsDto, Comments.class);
            post.get().getComments().add(comments);
            postRepository.save(post.get());
            return commentsDto;
        }
        throw new RuntimeException("Post not found");
    }
}
