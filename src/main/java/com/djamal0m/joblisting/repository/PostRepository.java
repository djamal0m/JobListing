package com.djamal0m.joblisting.repository;

import com.djamal0m.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
