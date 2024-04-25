package com.example.projectPostApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectPostApi.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

}
