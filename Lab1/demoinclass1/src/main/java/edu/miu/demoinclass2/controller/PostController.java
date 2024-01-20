package edu.miu.demoinclass2.controller;

import edu.miu.demoinclass2.model.dto.PostDto;
import edu.miu.demoinclass2.service.PostService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

   @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id) {
        PostDto post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(@RequestParam(value = "author", required = false) String author,
                                                     @RequestParam(value = "subStringAuthor", required = false) String subStringAuthor) {
        List<PostDto> posts = postService.getAllPost();

        return ResponseEntity.ok(posts.stream()
                .filter(post -> !(StringUtils.isEmpty(author)) ? post.getAuthor().toLowerCase().equals(author.toLowerCase()) : true)
                .filter(post -> !(StringUtils.isEmpty(subStringAuthor)) ? post.getAuthor().toLowerCase().contains(subStringAuthor.toLowerCase()) : true)
                .collect(Collectors.toList()));
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
}
