package com.djamal0m.joblisting.repository;

import com.djamal0m.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
