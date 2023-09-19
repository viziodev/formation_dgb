package com.dgb.formation_dgb.security.dto;

import com.dgb.formation_dgb.security.entities.Role;
import com.dgb.formation_dgb.security.entities.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    List<RoleResponse> roles ;

    public static UserResponse  toDto(Utilisateur utilisateur){
        return UserResponse
                .builder()
                .id(utilisateur.getId())
                .username(utilisateur.getUsername())
                .roles(utilisateur.getRoles().stream()
                        .map(RoleResponse::toDto)
                        .collect(Collectors.toList()))
                .build();
    }


}
