package com.djamal0m.joblisting.service;

import com.djamal0m.joblisting.model.Post;
import com.djamal0m.joblisting.repository.PostRepository;
import com.djamal0m.joblisting.repository.SearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final SearchRepository searchRepository;
    private final PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
    public List<Post> searchPost(String text){
        return searchRepository.findByText(text);
    }
    public Post createPost(Post post){
       return postRepository.save(post);
    }
}
