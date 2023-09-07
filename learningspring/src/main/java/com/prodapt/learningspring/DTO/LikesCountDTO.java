package com.prodapt.learningspring.DTO;

public class LikesCountDTO {

	private int postId;
	private int likesCount;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	
	public String toString() {
		return String.valueOf(likesCount);
	}
	
}
