package io.ansan.sistemaexamenes.controllers;

import io.ansan.sistemaexamenes.config.JwtUtils;
import io.ansan.sistemaexamenes.entity.JwtRequest;
import io.ansan.sistemaexamenes.entity.JwtResponse;
import io.ansan.sistemaexamenes.services.UserService;
import io.ansan.sistemaexamenes.services.impl.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class AuthenticationController {

  private AuthenticationManager authenticationManager;

  private UserDetailsServiceImpl userDetailsService;

  private JwtUtils jwtUtils;

  private UserService userService;

  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
  public ResponseEntity<?> generateToken(@RequestBody JwtRequest  jwtRequest) {
    try {
      authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
    } catch (UsernameNotFoundException e) {
      return ResponseEntity.badRequest().body("Username not found");
    }

    var userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
    var jwt = jwtUtils.generateToken(userDetails);

    return ResponseEntity.ok(new JwtResponse(jwt));
  }

  public void authenticate (String username, String password) {
    var localUser = userService.getUser(username);
    if (localUser == null) {
      throw new UsernameNotFoundException("User not found");
    }

    //var match = bCryptPasswordEncoder.matches(password, localUser.getPassword());
    var match = localUser.getPassword().equals(password);
    if (!match) {
      throw new BadCredentialsException("Incorrect password");
    }

    System.out.println("Correct");
  }


  @GetMapping("/current-user")
  public ResponseEntity<?> getCurrentUser(HttpServletRequest request) {
    var token = request.getHeader("Authorization");
    if(token == null) {
      return ResponseEntity.badRequest().body("Token not found");
    }
    token = token.substring(7);
    var username = jwtUtils.extractUsername(token);
    var userDetails = this.userDetailsService.loadUserByUsername(username);
    return ResponseEntity.ok(userDetails);
  }

}
