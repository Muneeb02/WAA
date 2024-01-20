package edu.miu.demoinclass2.repo;

import edu.miu.demoinclass2.model.Post;
import edu.miu.demoinclass2.model.dto.PostDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo {
    List<PostDto> findAll();
    Post findById(long id);

    Post creatPost(String title, String content, String author);

    PostDto updatePost(long id, PostDto postDto);
    boolean deletePost(long id);
}
