package com.dgb.formation_dgb.security.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {
    String generate(UserDetails userDetails,int ttl,boolean refresh);
    UserDetails authenticationWithPassword(String username,String password);
    UserDetails authenticationWithRefreshToken(String refreshToken);
}
