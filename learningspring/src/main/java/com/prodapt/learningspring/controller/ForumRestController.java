package com.prodapt.learningspring.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.learningspring.DTO.PostDTO;
import com.prodapt.learningspring.controller.exception.ResourceNotFoundException;
import com.prodapt.learningspring.entity.Comment;
import com.prodapt.learningspring.entity.LikeId;
import com.prodapt.learningspring.entity.LikeRecord;
import com.prodapt.learningspring.entity.Post;
// import com.prodapt.learningspring.entity.User;
import com.prodapt.learningspring.repository.CommentCRUDRepository;
import com.prodapt.learningspring.repository.LikeCRUDRepository;
import com.prodapt.learningspring.repository.LikeCountRepository;
import com.prodapt.learningspring.repository.PostRepository;
// import com.prodapt.learningspring.repository.UserRepository;
import com.prodapt.learningspring.repository.UserRepository;



@RestController
@RequestMapping("/newforum")
@CrossOrigin
public class ForumRestController {

	@Autowired
	  private PostRepository postRepository;

	  @Autowired
	  private UserRepository userRepository;

	  @Autowired
	  private LikeCountRepository likeCountRepository;

	  @Autowired
	  private LikeCRUDRepository likeCRUDRepository;

	  @Autowired
	  private CommentCRUDRepository commentCRUDRepository;
	
	@GetMapping("/post/{id}")
	@ResponseBody
	  public ResponseEntity<PostDTO> postDetail(@PathVariable int id) throws ResourceNotFoundException {

	    Optional<Post> post = postRepository.findById(id);
	    if (post.isEmpty()) {
	      throw new ResourceNotFoundException("No post with the requested ID");
	    }
	    PostDTO postDTO = new PostDTO();
		postDTO.setPostId(id);
		postDTO.setContent(post.get().getContent());
		postDTO.setCreatedTime(post.get().getCreatedTime());
		postDTO.setLikesCount(likeCountRepository.countByPostId(id));
	    return ResponseEntity.ok(postDTO);
	  }



	@GetMapping("/comment/{id}")
	@ResponseBody
	public ResponseEntity<List<Comment>> commentsdetail(@PathVariable int id) throws ResourceNotFoundException {
		List<Comment>  comments = commentCRUDRepository.findByPostId(id);
		if(comments.isEmpty()){
			throw new ResourceNotFoundException("No comments with the requested ID");
		}
		for (Comment comment: comments){
			comment.getPostId();
			comment.getContent();
			comment.getUserId();
			comment.getCommentedTime();
		}
		
		return ResponseEntity.ok(comments);

	}

	 @PostMapping("addComment/{id}")
	 @ResponseBody
 	public List<Comment> postComment(@PathVariable int id,@RequestBody Comment comment) {
	//   User user = userRepository.findByName(commenterName).get();
		List<Comment>  comments = commentCRUDRepository.findByPostId(id);
		Pattern pattern = Pattern.compile("@(\\w+)");
		Matcher matcher = pattern.matcher(comment.getContent());

        // Extract and store tags
        while (matcher.find()) {
            comment.setMentions(matcher.group(1));
        }
		
	  	comment.setUserId( 2);
		comment.setCommentedTime(new Date());
   		commentCRUDRepository.save(comment);
   		return comments;
 }

 	@PostMapping("/like/{id}")
	@ResponseBody
  	public Post postLike(@PathVariable int id) {
    LikeId likeId = new LikeId();
	likeId.setUser(userRepository.findById(2).get());
	var post = postRepository.findById(id).get();
    likeId.setPost(post);
    LikeRecord like = new LikeRecord();
    like.setLikeId(likeId);
    like.setLikedTime(new Date());
    likeCRUDRepository.save(like);
	return post;

  }
}
