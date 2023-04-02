package io.ansan.sistemaexamenes.repository;

import io.ansan.sistemaexamenes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category, Long>{

}