package edu.miu.demoinclass2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    private long id;
    private String name;
    @OneToMany
    @JoinColumn
    private List<Post> posts;

}
