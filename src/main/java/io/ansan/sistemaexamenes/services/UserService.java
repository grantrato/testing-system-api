package io.ansan.sistemaexamenes.services;

import io.ansan.sistemaexamenes.entity.User;
import io.ansan.sistemaexamenes.entity.UserRol;

import java.util.Set;

public interface UserService {
  User saveUser(User user, Set<UserRol> userRoles) throws Exception;
  User getUser(String username);
  void deleteUser(Long id);
}
