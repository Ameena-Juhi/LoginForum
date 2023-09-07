package com.prodapt.learningspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.learningspring.entity.Post;

@Service
public class LikeCountService {

	public List<Post> posts;
	public int getPostId(Post posts) {
		for(Post post: posts) {
			return post.getId();
		}
	}
}
