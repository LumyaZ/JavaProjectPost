package com.example.projectPostApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectPostApi.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long>  {

}
