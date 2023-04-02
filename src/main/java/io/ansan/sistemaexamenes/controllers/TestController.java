package io.ansan.sistemaexamenes.controllers;

import io.ansan.sistemaexamenes.entity.Test;
import io.ansan.sistemaexamenes.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {
  @Autowired
  private TestService testService;

  @PostMapping("/")
  public ResponseEntity<Test> saveTest(@RequestBody Test test){
      return ResponseEntity.ok(testService.createTest(test));
  }

  @GetMapping("/{id}")
  public Test listTestById(@PathVariable("id") Long id){
      return testService.getTest(id);
    }

  @GetMapping("/")
  public ResponseEntity<?> listCategories(){
      return ResponseEntity.ok(testService.getTests());
    }

  @PutMapping("/")
  public ResponseEntity<Test> updateTest(@RequestBody Test test){
      return ResponseEntity.ok(testService.updateTest(test));
    }

  @DeleteMapping("/{id}")
  public void deleteTest(@PathVariable("id") Long id){
      testService.deleteTest(id);
    }
}