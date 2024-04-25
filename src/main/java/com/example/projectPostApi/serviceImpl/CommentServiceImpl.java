package com.example.projectPostApi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectPostApi.entity.Comment;
import com.example.projectPostApi.repository.CommentRepo;
import com.example.projectPostApi.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
    private CommentRepo CommentRepository;
	
	@Override
    public Comment createComment(Comment comment) {
        return CommentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return CommentRepository.findById(id).orElseThrow(()-> new RuntimeException("Comment not Found"));
    }
    
    @Override
    public Comment updateComment(Long id,Comment entity) {
    	Comment comment = CommentRepository.findById(id).orElseThrow(()-> new RuntimeException("comment not found"));
    	comment.setBody(entity.getBody());
    	comment.setEmail(entity.getEmail());
    	comment.setName(entity.getName());
    	comment.setPost(entity.getPost());
        return CommentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
    	Comment comment = CommentRepository.findById(id).orElseThrow(() -> new RuntimeException("comment not found"));
    	CommentRepository.delete(comment);
    }

	@Override
	public List<Comment> getAllComments() {
        return CommentRepository.findAll();
	}
	
}
