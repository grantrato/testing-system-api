package io.ansan.sistemaexamenes.controllers;

import io.ansan.sistemaexamenes.entity.Rol;
import io.ansan.sistemaexamenes.entity.User;
import io.ansan.sistemaexamenes.entity.UserRol;
import io.ansan.sistemaexamenes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/")
  public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {
    Set<UserRol> userRoles = new HashSet<>();
    Rol rol = new Rol();
    rol.setRolId(2L);
    rol.setName("NORMAL");

    UserRol userRol = new UserRol();
    userRol.setUser(user);
    userRol.setRol(rol);

    userRoles.add(userRol);

    return ResponseEntity.ok(userService.saveUser(user, userRoles));

  }

  @GetMapping("/{username}")
  public ResponseEntity<?> getUser(@PathVariable("username") String username) throws Exception {
    return ResponseEntity.ok(userService.getUser(username));
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long id) throws Exception {
    userService.deleteUser(id);
  }

}
