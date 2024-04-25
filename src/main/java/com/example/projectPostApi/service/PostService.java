package com.example.projectPostApi.service;

import java.util.List;

import com.example.projectPostApi.entity.Post;

public interface PostService {

	Post createPost(Post post);

    Post getPostById(Long id);

    List<Post> getAllPosts();

    Post updatePost(Long id,Post post);

    void deletePost(Long id);
}
