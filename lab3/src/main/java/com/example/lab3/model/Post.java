package com.example.lab3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    long id;
    String title;
    String content;
    String author;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    List<Comments> comments;

}
