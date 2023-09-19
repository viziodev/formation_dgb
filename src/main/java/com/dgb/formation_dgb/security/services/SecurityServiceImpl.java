package com.dgb.formation_dgb.security.services;

import com.dgb.formation_dgb.security.dto.RoleRequest;
import com.dgb.formation_dgb.security.dto.RoleResponse;
import com.dgb.formation_dgb.security.dto.UserRequest;
import com.dgb.formation_dgb.security.dto.UserResponse;
import com.dgb.formation_dgb.security.entities.Role;
import com.dgb.formation_dgb.security.entities.Utilisateur;
import com.dgb.formation_dgb.security.repositories.RoleRepository;
import com.dgb.formation_dgb.security.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private RoleRepository roleRepository;
    private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserResponse storeUser(UserRequest userRequest) {
        List<Role> roles = userRequest.getRoles().stream()
                .map(idRole -> {
                    return roleRepository.findById(idRole)
                            .orElse(null);
                })
                .filter(role -> role!=null)
                .collect(Collectors.toList());
        Utilisateur utilisateur=userRequest.toEntity();
        utilisateur.setRoles(roles);
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return  UserResponse.toDto(utilisateurRepository.save(utilisateur));
    }

    @Override
    public List<UserResponse> allUser() {
        return utilisateurRepository.findAll()
                .stream()
                .map(UserResponse::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleResponse> allRole() {
        return roleRepository
                .findAll().stream()
                .map(RoleResponse::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse storeRole(RoleRequest roleRequest) {
        return RoleResponse.toDto(roleRepository.save(roleRequest.toEntity()));
    }
}
