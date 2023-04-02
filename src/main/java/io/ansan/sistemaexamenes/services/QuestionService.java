package io.ansan.sistemaexamenes.services;

import io.ansan.sistemaexamenes.entity.Question;
import io.ansan.sistemaexamenes.entity.Test;

import java.util.Set;

public interface QuestionService {
  Question addQuestion(Question question);

  Question updateQuestion(Question question);

  Set<Question> getQuestions();

  Question getQuestion(Long id);

  Set<Question> getQuestionsOfTest(Test test);

  void deleteQuestion(Long id);

}