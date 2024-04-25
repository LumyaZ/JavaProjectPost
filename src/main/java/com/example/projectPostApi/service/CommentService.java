package com.example.projectPostApi.service;

import java.util.List;

import com.example.projectPostApi.entity.Comment;

public interface CommentService {
	Comment createComment(Comment comment);

	Comment getCommentById(Long id);

    List<Comment> getAllComments();

    Comment updateComment(Long id,Comment comment);

    void deleteComment(Long id);
    
}
