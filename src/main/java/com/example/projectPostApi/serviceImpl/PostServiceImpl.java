package com.example.projectPostApi.serviceImpl;

import com.example.projectPostApi.entity.Post;
import com.example.projectPostApi.repository.PostRepo;
import com.example.projectPostApi.service.PostService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostRepo postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not Found"));
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long id,Post entity) {
        
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found"));
        post.setContent(entity.getContent());
        post.setDescription(entity.getDescription());
        post.setTitle(entity.getTitle());
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }

}
