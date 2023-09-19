package com.dgb.formation_dgb.security.services;

import com.dgb.formation_dgb.security.entities.Utilisateur;
import com.dgb.formation_dgb.security.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> optionalUser = utilisateurRepository.findByUsername(username);
        if(optionalUser.isEmpty()){
            throw  new UsernameNotFoundException(String.format("Ce %s n'existe pas",username));
        }
        Utilisateur utilisateur=optionalUser.get();
        List<SimpleGrantedAuthority> roles = utilisateur.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        return User
                .builder()
                .password(utilisateur.getPassword())
                .username(utilisateur.getUsername())
                .authorities(roles )
                .build();
    }
}
