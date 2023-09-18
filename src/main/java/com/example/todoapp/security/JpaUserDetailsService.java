package com.example.todoapp.security;

import com.example.todoapp.entity.User;
import com.example.todoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    return new org.springframework.security.core.userdetails.User(
      user.getUsername(),
      user.getPassword(),
      true,
      true,
      true,
      true,
      Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString()))
    );
  }
}
