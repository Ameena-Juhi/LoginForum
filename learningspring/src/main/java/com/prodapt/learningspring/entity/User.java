package com.prodapt.learningspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="User")
@Data
public class User {

	@Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @Column
  private String name;
  private String password;
  
  public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getId() {
	return this.id;
  }
  
  public String getName() {
	  return this.name;
  }
  
  public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}