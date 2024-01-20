package edu.miu.demoinclass2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PostDto {

    long id;
    String title;
    String content;
    String author;
}




