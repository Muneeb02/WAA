package edu.miu.demoinclass2.service.Impl;

import edu.miu.demoinclass2.model.Post;
import edu.miu.demoinclass2.model.dto.PostDto;
import edu.miu.demoinclass2.repo.PostRepo;
import edu.miu.demoinclass2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Override
    public PostDto getPostById(long id) {

        Post post = postRepo.findById(id);
        if(post != null){
            return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
        }else{
            System.out.println("Post not found");
            return null;
        }
    }

    @Override
    public List<PostDto> getAllPost() {
        return postRepo.findAll();
    }

    @Override
    public PostDto createNewPost(PostDto postDTO) {
        Post post = postRepo.creatPost(postDTO.getTitle(), postDTO.getContent(), postDTO.getAuthor());
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    @Override
    public PostDto updatePost(long id, PostDto postDTO) {
        return postRepo.updatePost(id, postDTO);
    }

    @Override
    public boolean deletePostById(long id) {
        return postRepo.deletePost(id);
    }
}
