package com.dgb.formation_dgb.security.dto;

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
public class UserRequest {
    private String username;
    private String password;
    List<Long> roles ;

    public Utilisateur toEntity(){
        return Utilisateur.builder()
                .username(this.getUsername())
                .password(this.getPassword())
                .build();
    }
}
