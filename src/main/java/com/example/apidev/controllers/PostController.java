package com.example.apidev.controllers;

import com.example.apidev.dtos.PostDto;
import com.example.apidev.models.PostModel;
import com.example.apidev.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostModel>> listAllPosts() {
        var postList = postService.listAlPost();
        return ResponseEntity.ok().body(postList);
    }

    @PostMapping("/posts")
    public ResponseEntity<PostModel> savePost(@RequestBody @Valid PostDto postDto, PostModel post) {
        var newPost = postService.createPost(post);
        BeanUtils.copyProperties(postDto, newPost);
        return ResponseEntity.status(HttpStatus.OK).body(newPost);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> listPostsId(@PathVariable UUID id) {
        var postId = postService.listId(id);
        if (postId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(postId);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable UUID id, @RequestBody PostModel post, @Valid PostDto postDto) {
        var post0 = postService.listId(id);
        if (post0 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
        post0.setTitle(post.getTitle());
        post0.setDescription(post.getDescription());
        var updatePost = postService.createPost(post0);
        BeanUtils.copyProperties(postDto, updatePost);
        return ResponseEntity.status(HttpStatus.OK).body(updatePost);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable UUID id) {
        var post0 = postService.listId(id);
        if (post0 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not exists");
        }
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post Deleted");

    }

}
