package io.ansan.sistemaexamenes.repository;

import io.ansan.sistemaexamenes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
