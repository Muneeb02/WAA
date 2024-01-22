package com.example.lab4.service;

import com.example.lab4.dto.CommentsDto;



public interface CommentsService {

    CommentsDto createCommentByPostId(long id, CommentsDto commentsDto);
}
