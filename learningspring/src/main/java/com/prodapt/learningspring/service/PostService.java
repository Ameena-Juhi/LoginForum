package com.prodapt.learningspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.prodapt.learningspring.repository.PostRepository;

import com.prodapt.learningspring.entity.Post;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> getPosts(int offset, int limit) {
        PageRequest pageable = PageRequest.of(offset / limit, limit);
        Page<Post> page = postRepository.findAll(pageable);
        return page.getContent();
	}
	
	
}
