package com.dgb.formation_dgb.security.controllers;

import com.dgb.formation_dgb.security.IAuthenticationFacade;
import com.dgb.formation_dgb.security.dto.UserLoginRequest;
import com.dgb.formation_dgb.security.services.JwtTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${jwt.ttlToken}")
    private int  ttlToken;
    @Value("${jwt.ttlRefreshToken}")
    private int  ttlRefreshToken;
    private final JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAuthenticationFacade authenticationFacade;
    public AuthController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }


    @GetMapping("/profile")
    public Authentication authentication(){
          return authenticationFacade.getAuthentication() ;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String , String>> login(@RequestBody UserLoginRequest userRequest){
        Map<String , String> token=new HashMap<>();
        UserDetails userDetails=null;

                  if(userRequest.isWithPassword()){
                      Authentication authentication=  authenticationManager.
                              authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername()
                                      ,userRequest.getPassword()));
                      SecurityContextHolder.getContext().setAuthentication(authentication);
                      userDetails= (UserDetails)authentication.getPrincipal();
                  }else{
                      userDetails=jwtTokenService.authenticationWithRefreshToken(userRequest.getRefreshToken());
                  }

          //2-Creer Payload
             token.put("access-token", jwtTokenService.generate(userDetails,ttlToken,false));
            if(userRequest.isRefresh()){
                token.put("refresh-token",jwtTokenService.generate(userDetails,ttlRefreshToken,true));
            }

        return ResponseEntity.ok(token);
    }


}
