package io.ansan.sistemaexamenes.services;

import io.ansan.sistemaexamenes.entity.Test;

import java.util.Set;

public interface TestService {
  Test createTest(Test test);
  Test updateTest(Test test);

  Set<Test> getTests();

  Test getTest(Long id);

  void deleteTest(Long id);
}