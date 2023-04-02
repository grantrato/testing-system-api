package io.ansan.sistemaexamenes.repository;

import io.ansan.sistemaexamenes.entity.Question;
import io.ansan.sistemaexamenes.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    Set<Question> findByTest(Test test);
}