package com.dgb.formation_dgb.security.dto;

import com.dgb.formation_dgb.security.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    private String role;
    public Role toEntity() {
        return Role
                .builder()
                .roleName(this.getRole())
                .build();
    }
}
