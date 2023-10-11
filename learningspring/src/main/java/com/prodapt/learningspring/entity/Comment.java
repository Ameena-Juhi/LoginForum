package com.prodapt.learningspring.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Comment{
  

	@Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @Column
  private String content;
  private int userId;
  private int postId;
  
  @Temporal(value=TemporalType.TIMESTAMP )
  @Column(name="commentedTime")
  private Date commentedTime;

  @Column
  private String mentions;
  
public Date getCommentedTime() {
	return commentedTime;
}
public void setCommentedTime(Date commentedTime) {
	this.commentedTime = commentedTime;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getPostId() {
	return postId;
}
public void setPostId(int postId) {
	this.postId = postId;
}
  
 
  
}