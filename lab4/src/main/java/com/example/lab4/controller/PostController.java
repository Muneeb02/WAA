package com.example.lab4.controller;


import com.example.lab4.dto.CommentsDto;
import com.example.lab4.dto.PostDto;
import com.example.lab4.service.CommentsService;
import com.example.lab4.service.PostService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

   @Autowired
   private PostService postService;
   @Autowired
   private CommentsService commentsService;


    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(@RequestParam(value = "author", required = false) String author,
                                                     @RequestParam(value = "subStringAuthor", required = false) String subStringAuthor) {
        List<PostDto> posts = postService.getAllPost();

        return ResponseEntity.ok(posts.stream()
                .filter(post -> !(StringUtils.isEmpty(author)) ? post.getAuthor().toLowerCase().equals(author.toLowerCase()) : true)
                .filter(post -> !(StringUtils.isEmpty(subStringAuthor)) ? post.getAuthor().toLowerCase().contains(subStringAuthor.toLowerCase()) : true)
                .collect(Collectors.toList()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id) {
        PostDto post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }


    @PostMapping
    public ResponseEntity<PostDto> createNewPost(@RequestBody PostDto postDTO) {
        PostDto post = postService.createNewPost(postDTO);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDTO) {
        PostDto post = postService.updatePost(id, postDTO);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable long id) {
        boolean deleted = postService.deletePostById(id);
        if (deleted) {
            return ResponseEntity.ok("Post with ID: " + id + " has been deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/comment")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> addComment(@PathVariable("id") long id, @RequestBody CommentsDto commentsDto){
        CommentsDto commentsDto1 = commentsService.createCommentByPostId(id,commentsDto);
        return ResponseEntity.ok(commentsDto1);
    }
}
