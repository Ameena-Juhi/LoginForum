package com.prodapt.learningspring.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;

@Component
public class Student {
  private int id;
  private String name;
  @Min(value = 0)
  private int score;
  private int rank;

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getRank() {
    return this.rank;
  }

  public String getName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }

  public int getId() {
    return this.id;
  }
}
