package com.prodapt.learningspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;
import com.prodapt.learningspring.repository.LikeCRUDRepository;
import com.prodapt.learningspring.repository.LikeCountRepository;
import com.prodapt.learningspring.repository.PostRepository;
import com.prodapt.learningspring.service.CustomUserDetailsService;
import com.prodapt.learningspring.service.DomainUserService;

@Controller
public class PostsListController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private LikeCountRepository likeCountRepository;
	
	@Autowired
	private CustomUserDetailsService userDetails;
	
	@Autowired
	private DomainUserService domainUserService;
	
	
	
	@RequestMapping("/list")
	public String getallPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		List<Post> postList =  (List<Post>) postRepository.findAll();
		model.addAttribute("posts", postList);
		model.addAttribute("userName", userDetails.getUsername());
//		model.addAttribute("likeCount",likeCountRepository.countByPostId()));
		return("forum/PostsList");
	}
}
