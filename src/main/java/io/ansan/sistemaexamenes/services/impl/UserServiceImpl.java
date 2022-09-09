package io.ansan.sistemaexamenes.services.impl;

import io.ansan.sistemaexamenes.entity.User;
import io.ansan.sistemaexamenes.entity.UserRol;
import io.ansan.sistemaexamenes.repository.RolRepo;
import io.ansan.sistemaexamenes.repository.UserRepo;
import io.ansan.sistemaexamenes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepo userRepo;

  @Autowired
  private RolRepo rolRepo;


  @Override
  public User saveUser(User user, Set<UserRol> userRoles) throws Exception {
    var localUser = userRepo.findByUsername(user.getUsername());
    if (localUser != null) {
      return null;
    }else {
      for(UserRol userRole: userRoles){
        rolRepo.save(userRole.getRol());
      }
      user.getUserRoles().addAll(userRoles);
      localUser = userRepo.save(user);
    }
    return localUser;
  }

  @Override
  public User getUser(String username) {
    return userRepo.findByUsername(username);
  }

  @Override
  public void deleteUser(Long id) {
    userRepo.deleteById(id);
  }
}
