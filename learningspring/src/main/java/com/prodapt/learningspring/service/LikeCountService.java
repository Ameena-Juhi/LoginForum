package com.prodapt.learningspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import com.prodapt.learningspring.DTO.LikesCountDTO;
import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.repository.LikeCRUDRepository;

@Service
public class LikeCountService {
	
	 private final LikeCRUDRepository likeCRUDRepository;

	    public LikeCountService(@Autowired LikeCRUDRepository likeCRUDRepository) {
	        this.likeCRUDRepository = likeCRUDRepository;
	    }

    public List<LikesCountDTO> getLikesCounts(List<Post> posts) {
        List<LikesCountDTO> likesCountDTOs = new ArrayList<>();

        for (Post post : posts) {
            LikesCountDTO likesCountDTO = new LikesCountDTO();
            likesCountDTO.setPostId(post.getId());

            // Populate likesCount (You need to implement this logic)
            int likesCount = calculateLikesCountForPost(post);
            likesCountDTO.setLikesCount(likesCount);

            likesCountDTOs.add(likesCountDTO);
        }

        return likesCountDTOs;
    }

    // You need to implement the logic to calculate the likes count for a post
    private int calculateLikesCountForPost(Post post) {
        return likeCRUDRepository.countByLikeIdPost(post);
         // Replace with your actual logic
    }
}
