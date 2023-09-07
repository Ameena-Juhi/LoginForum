package com.prodapt.learningspring.entity;



import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Post {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  @Column
  private String content;
  
  @Temporal(value=TemporalType.TIMESTAMP )
  @Column(name="createdTime")
  private Date createdTime;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private User author;
  
  public User getAuthor() {
	  return author;
  }

  public Date getCreatedTime() {
	return createdTime;
}

public void setCreatedTime(Date createdTime) {
	this.createdTime = createdTime;
}

public void setId(int id) {
	this.id = id;
}

public void setAuthor(User author) {
      this.author = author;
  }

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public int getId() {
	return id;
}

}