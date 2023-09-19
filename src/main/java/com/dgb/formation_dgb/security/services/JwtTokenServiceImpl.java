package com.dgb.formation_dgb.security.services;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService{
    private JwtEncoder jwtEncoder;
    private AuthenticationManager authenticationManager;
    private JwtDecoder jwtDecoder;
    private UserDetailsService userDetailsService;
    @Override
    public String generate(UserDetails userDetails, int ttl,boolean refresh) {
        List<String> roles = userDetails.getAuthorities()
                 .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Instant instant =Instant.now();
        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
                .issuedAt(instant)
                .expiresAt(instant.plus(ttl, ChronoUnit.MINUTES))
                .subject(userDetails.getUsername())
                .claim("roles",refresh?"":roles)
                .build();
        //3-Generer le token
        JwtEncoderParameters jwtEncoderParameters=JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS512).build(),
                jwtClaimsSet
        );

        return jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
    }

    @Override
    public UserDetails authenticationWithPassword(String username, String password) {
        Authentication authentication=  authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(username
                        ,password));
        return (UserDetails)authentication.getPrincipal();
    }

    @Override
    public UserDetails authenticationWithRefreshToken(String refreshToken) {
           Jwt jwtTokenDecode=jwtDecoder.decode(refreshToken);
            String username =jwtTokenDecode.getSubject();
            return userDetailsService.loadUserByUsername(username);
    }
}
