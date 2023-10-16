package com.prodapt.learningspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
	@Query(value = "select count(*) from post p", nativeQuery = true)
	int findCountofPosts();

	@Query(value = "SELECT COUNT(*) FROM post WHERE DATE(post.created_time) = DATE(NOW())", nativeQuery = true)
	int CountPostsCreatedTodayBy();

	@Query(value = "SELECT COUNT(*) FROM post WHERE MONTH(post.created_time) = MONTH(NOW())", nativeQuery = true)
	int CountPostsCreatedInThisMonthBy();

	Page<Post> findAll(Pageable pageable);

}