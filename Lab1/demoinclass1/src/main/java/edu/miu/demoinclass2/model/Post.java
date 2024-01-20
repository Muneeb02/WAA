package edu.miu.demoinclass2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;

}
