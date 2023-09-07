package com.prodapt.learningspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.entity.LikeRecord;
import com.prodapt.learningspring.entity.Post;

public interface LikeCRUDRepository extends CrudRepository<LikeRecord, Integer>{
	 public Integer countByLikeIdPost(Post post);
}