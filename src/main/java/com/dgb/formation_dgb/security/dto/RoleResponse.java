package com.dgb.formation_dgb.security.dto;

import com.dgb.formation_dgb.security.entities.Role;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RoleResponse {
    private Long id;
    private String roleName;
    public static  RoleResponse toDto(Role role) {
        return RoleResponse
                .builder()
                .roleName(role.getRoleName())
                .id(role.getId())
                .build();
    }
}
