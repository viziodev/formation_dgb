package com.dgb.formation_dgb.security.controllers;

import com.dgb.formation_dgb.security.dto.UserLoginRequest;
import com.dgb.formation_dgb.security.services.JwtTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")

public class SecurityController {

    @Value("${jwt.ttlToken}")
    private int  ttlToken;
    @Value("${jwt.ttlRefreshToken}")
    private int  ttlRefreshToken;
    private final JwtTokenService jwtTokenService;
    public SecurityController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @GetMapping("/profile")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String , String>> login(@RequestBody UserLoginRequest userRequest){
        Map<String , String> token=new HashMap<>();
        UserDetails userDetails=null;
          userDetails=userRequest.isWithPassword()
                  ? jwtTokenService.authenticationWithPassword(userRequest.getUsername(), userRequest.getPassword())
                  : jwtTokenService.authenticationWithRefreshToken(userRequest.getRefreshToken());
          //2-Creer Payload
           token.put("access-token", jwtTokenService.generate(userDetails,ttlToken,false));
            if(userRequest.isRefresh()){
                token.put("refresh-token",jwtTokenService.generate(userDetails,ttlRefreshToken,true));
            }

        return ResponseEntity.ok(token);
    }


}
