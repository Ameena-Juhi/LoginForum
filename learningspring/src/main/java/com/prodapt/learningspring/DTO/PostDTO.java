package com.prodapt.learningspring.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {
    private int postId;
    private String content;
    private Date createdTime;
    private int likesCount;

    public String toString() {
		return String.valueOf(likesCount); 
        
	}

    

}
