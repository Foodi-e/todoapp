package com.example.todoapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "USERS")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
  @Column(name = "id")
  private long id;

  @Column(nullable = false, name = "username")
  private String username;

  @Column(nullable = false, name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, name = "role")
  private Role role = Role.VIEWER;

  public enum Role {
    ADMIN,
    SUPPORT,
    VIEWER
  }
}
