package io.ansan.sistemaexamenes.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Test {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long testId;

  private String title;

  private String description;

  private String scoreMax;

  private String noQuestions;

  private boolean active = false;

  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;

  @OneToMany(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Question> questions = new HashSet<>();



  public Long getTestId() {
    return testId;
  }

  public void setTestId(Long testId) {
    this.testId = testId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getScoreMax() {
    return scoreMax;
  }

  public void setScoreMax(String scoreMax) {
    this.scoreMax = scoreMax;
  }

  public String getNoQuestions() {
    return noQuestions;
  }

  public void setNoQuestions(String noQuestions) {
    this.noQuestions = noQuestions;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Set<Question> getQuestions() {
      return questions;
  }

  public void setQuestions(Set<Question> questions) {
      this.questions = questions;
  }
}
