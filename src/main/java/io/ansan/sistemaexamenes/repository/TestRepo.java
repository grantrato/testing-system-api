package io.ansan.sistemaexamenes.repository;

import io.ansan.sistemaexamenes.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {

}