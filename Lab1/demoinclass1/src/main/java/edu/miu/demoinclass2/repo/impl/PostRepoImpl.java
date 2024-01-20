package edu.miu.demoinclass2.repo.impl;

import edu.miu.demoinclass2.model.Post;
import edu.miu.demoinclass2.model.dto.PostDto;
import edu.miu.demoinclass2.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {

    private List<Post> posts =  new ArrayList<>();;
    private static int postId = 100;
    public PostRepoImpl(){
        Post p1 = new Post(101, "Game","Nice game, will play","Rockstar");
        Post p2 = new Post(102, "Game","Nice game, will play","EA");
        Post p3 = new Post(103, "Game","Nice game, will play","UbiSoft");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);


    }


    @Override
    public List<PostDto> findAll() {
        return posts.stream()
                .map(post -> new PostDto(post.getId(), post.getTitle(), post.getAuthor(), post.getContent()))
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(long id) {
        return posts.stream()
                .filter(a -> a.getId()== id)
                .findFirst().get();
    }

    @Override
    public Post creatPost(String title, String content, String author) {
        Post post = new Post(postId++, title, content, author);
        posts.add(post);
        return post;
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post postTmp = findById(id);
        if(postTmp != null){
            if(postDto.getTitle()!=null){
                postTmp.setTitle(postDto.getTitle());
            }
            if(postDto.getContent()!=null){
                postTmp.setContent(postDto.getContent());
            }

            if(postDto.getAuthor()!=null){
                postTmp.setAuthor(postDto.getAuthor());
            }
            return new PostDto(postTmp.getId(), postTmp.getTitle(),postTmp.getContent(), postTmp.getAuthor());
        }else {
            System.out.println("Post not found");
            return null;
        }

    }


    @Override
    public boolean deletePost(long id) {
        Post post = findById(id);
        if (post != null){
            posts.remove(post);
            return true;
        }
        return false;
    }




}
