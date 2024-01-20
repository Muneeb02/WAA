package edu.miu.demoinclass2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

}
