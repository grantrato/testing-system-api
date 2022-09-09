package io.ansan.sistemaexamenes.config;

import io.ansan.sistemaexamenes.services.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private JwtUtils jwtUtils;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    var tokenRequestHeader = request.getHeader("Authorization");
    String username = null;
    String jwtToken = null;
    if (tokenRequestHeader != null && tokenRequestHeader.startsWith("Bearer ")) {
      jwtToken = tokenRequestHeader.substring(7);
      try {
        username = jwtUtils.extractUsername(jwtToken);
      } catch (ExpiredJwtException e) {
        log.info(e.getMessage());
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    } else {log.info("Token is not valid, no starts with bearer");}



    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      var userDetails = this.userDetailsService.loadUserByUsername(username);

      if (jwtUtils.validateToken(jwtToken, userDetails)) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      }
    }else { log.info("JWT Token is not valid 2"); }
    filterChain.doFilter(request, response);
  }
}

