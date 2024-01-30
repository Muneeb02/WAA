package com.example.lab3.service;

import com.example.lab3.dto.CommentsDto;



public interface CommentsService {

    CommentsDto createCommentByPostId(long id, CommentsDto commentsDto);
}
