package com.example.apidev.services;

import com.example.apidev.dtos.PostDto;
import com.example.apidev.models.PostModel;
import com.example.apidev.repositories.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostModel createPost(PostModel post) {
        return postRepository.save(post);
    }

    public List<PostModel> listAlPost() {
        return postRepository.findAll();
    }

    public PostModel listId(UUID id) {
        return postRepository.findById(id).orElse(null);
    }


    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }

}
