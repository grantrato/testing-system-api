package io.ansan.sistemaexamenes.controllers;

import io.ansan.sistemaexamenes.entity.Question;
import io.ansan.sistemaexamenes.entity.Test;
import io.ansan.sistemaexamenes.services.QuestionService;
import io.ansan.sistemaexamenes.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
  @Autowired
  private QuestionService questionService;

  @Autowired
  private TestService testService;


  @PostMapping("/")
  public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
      return ResponseEntity.ok(questionService.addQuestion(question));
  }

  @PutMapping("/")
  public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
      return ResponseEntity.ok(questionService.updateQuestion(question));
  }

  @GetMapping("/test/{testId}")
  public ResponseEntity<?> listQuestionsOfTest(@PathVariable("testId") Long id){
    Test test = testService.getTest(id);
    Set<Question> questions = test.getQuestions();

    List<?> tests = new ArrayList(questions);

    if(tests.size() > Integer.parseInt(test.getNoQuestions())){
        tests = tests.subList(0, Integer.parseInt(test.getNoQuestions() +1 ));
    }

    Collections.shuffle(tests);
    return ResponseEntity.ok(tests);
  }

  @GetMapping("/{questionId}")
  public Question listQuestionById(@PathVariable("questionId") Long id){
      return questionService.getQuestion(id);
  }

  @DeleteMapping("/{questionId}")
  public void deleteQuestion(@PathVariable("questionId") Long id){
      questionService.deleteQuestion(id);
  }
}