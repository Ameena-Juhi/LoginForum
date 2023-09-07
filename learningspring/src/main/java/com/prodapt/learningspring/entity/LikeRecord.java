package com.prodapt.learningspring.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class LikeRecord {
  
  @Column(unique=true)
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  @EmbeddedId
  private LikeId likeId;
  
  @Temporal(value=TemporalType.TIMESTAMP )
  @Column(name="likedTime")
  private Date likedTime;
  
public Date getLikedTime() {
	return likedTime;
}

public void setLikedTime(Date likedTime) {
	this.likedTime = likedTime;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public LikeId getLikeId() {
	return likeId;
}

public void setLikeId(LikeId likeId) {
	this.likeId = likeId;
}
  
  

}