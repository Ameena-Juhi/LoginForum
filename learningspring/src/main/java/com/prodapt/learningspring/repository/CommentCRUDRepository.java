package com.prodapt.learningspring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.entity.Comment;

public interface CommentCRUDRepository extends CrudRepository<Comment, Integer>{
    // Optional<Comment> findByuserName(String Name);

    List<Comment> findByPostId(int id);

}
