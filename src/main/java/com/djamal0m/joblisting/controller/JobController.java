package com.djamal0m.joblisting.controller;

import com.djamal0m.joblisting.dto.PostDTO;
import com.djamal0m.joblisting.model.Post;
import com.djamal0m.joblisting.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }
    @GetMapping("/posts/{text}")
    public ResponseEntity<List<Post>> searchPost(@PathVariable String text){
        return new ResponseEntity<>(postService.searchPost(text), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO){
        Post post = new Post();
        post.setProfile(postDTO.getProfile());
        post.setDesc(postDTO.getDesc());
        post.setExp(postDTO.getExp());
        post.setTechs(postDTO.getTechs());
        post.setLevelOfEducation(postDTO.getLevelOfEducation());
        post.setLocation(postDTO.getLocation());
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }
}
