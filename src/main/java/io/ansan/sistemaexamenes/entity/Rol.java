package io.ansan.sistemaexamenes.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="roles")
@Entity
public class Rol {
  @Id
  private Long rolId;
  private String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
  private Set<UserRol> userRoles = new HashSet<>();

  public Rol() {
  }

  public Long getRolId() {
    return rolId;
  }

  public void setRolId(Long rolId) {
    this.rolId = rolId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<UserRol> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Set<UserRol> userRoles) {
    this.userRoles = userRoles;
  }
}
