package com.example.lab3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Comments {

    @Id
    @GeneratedValue
    long id;
    String name;
    @ManyToOne
            @JoinColumn(name = "post_id")
    Post post;
}
