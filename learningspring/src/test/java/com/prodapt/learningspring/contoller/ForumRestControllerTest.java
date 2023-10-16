// package com.prodapt.learningspring.contoller;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.jdbc.Sql;

// import java.util.Date;
// import java.util.List;
// import java.util.Optional;
// import com.prodapt.learningspring.controller.ForumRestController;
// import com.prodapt.learningspring.controller.exception.ResourceNotFoundException;
// import com.prodapt.learningspring.DTO.PostDTO;
// import com.prodapt.learningspring.entity.Post;
// import com.prodapt.learningspring.repository.LikeCountRepository;
// import com.prodapt.learningspring.repository.PostRepository;

// public class ForumRestControllerTest {

//     private ForumRestController forumController;

//      // Mock dependencies
//     private PostRepository postRepository;
//     private LikeCountRepository likeCountRepository;

//     // @Test
//     // @Sql(statements = "INSERT INTO post (content, createdTime, author_id) VALUES ('TestContent', 2023-09-07 11:49:57.162000, 42)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//     // @Sql(statements = "DELETE FROM post WHERE content = 'TestContent'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//     // void testGetAllposts() {
//     //     assertEquals(1, postRepository.findAll());

//     // }
   

//     @BeforeEach
//     void setUp() {
//     forumController = new ForumRestController();
//     forumController.setPostRepository(postRepository);
//     forumController.setLikeCountRepository(likeCountRepository);
// }


//     @Test
//     public void testPostDetail() throws ResourceNotFoundException {
//         // Prepare test data
//         int postId = 1;
//         Post post = new Post();
//         post.setId(postId);
//         post.setContent("Test Content");
//         post.setCreatedTime(new Date());

//         // Stub the PostRepository to return the test data
//         when(postRepository.findById(postId)).thenReturn(Optional.of(post));

//         // Stub the LikeCountRepository to return a count
//         when(likeCountRepository.countByPostId(postId)).thenReturn(5);

//         // Call the controller method
//         ResponseEntity<PostDTO> response = forumController.postDetail(postId);

//         // Verify the response and content
//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         PostDTO postDTO = response.getBody();
//         assertEquals(postId, postDTO.getPostId());
//         assertEquals("Test Content", postDTO.getContent());
//         assertEquals(5, postDTO.getLikesCount());
//     }

//     @Test
//     public void testPostLike() {
//         // Prepare test data
//         int postId = 1;
//         Post post = new Post();
//         post.setId(postId);

//         // Stub the PostRepository to return the test data
//         when(postRepository.findById(postId)).thenReturn(Optional.of(post));

//         // Call the controller method
//         Post responsePost = forumController.postLike(postId);

//         // Verify the response and interaction with repositories
//         assertEquals(post, responsePost);
//         verify(postRepository, times(1)).findById(postId);
//         verify(likeCountRepository, times(1)).countByPostId(postId);
//     }

// }
