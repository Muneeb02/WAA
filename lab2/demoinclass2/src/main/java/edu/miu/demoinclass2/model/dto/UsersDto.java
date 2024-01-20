package edu.miu.demoinclass2.model.dto;

import edu.miu.demoinclass2.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    long id;
    String name;
    List<Post> posts;

}
