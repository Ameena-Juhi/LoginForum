import org.junit.jupiter.api.Test;

import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

class PostTest {

    @Test
    void testGetAuthor() {
        User user = new User();
        user.setId(1);
        user.setName("testuser");

        Post post = new Post();
        post.setAuthor(user);

        assertEquals(user, post.getAuthor());
    }

    @Test
    void testGetCreatedTime() {
        Date date = new Date();

        Post post = new Post();
        post.setCreatedTime(date);

        assertEquals(date, post.getCreatedTime());
    }

    @Test
    void testSetContent() {
        
        Post post = new Post();
        String content = "Test Content";
        post.setContent(content);

        assertEquals(content, post.getContent());
    }

    @Test
    void testSetId() {
        
        Post post = new Post();
        int id = 42;
        post.setId(id);

        
        assertEquals(id, post.getId());
    }
}
