package com.example.todoapp.dto;

import com.example.todoapp.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
  private long id;
  private String username;
  private String password;
  private User.Role role;
}
