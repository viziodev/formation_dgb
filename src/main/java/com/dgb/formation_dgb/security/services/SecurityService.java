package com.dgb.formation_dgb.security.services;

import com.dgb.formation_dgb.security.dto.RoleRequest;
import com.dgb.formation_dgb.security.dto.RoleResponse;
import com.dgb.formation_dgb.security.dto.UserRequest;
import com.dgb.formation_dgb.security.dto.UserResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SecurityService {
    UserResponse storeUser(UserRequest userRequest);
    List<UserResponse>  allUser();

    List<RoleResponse>  allRole();

    RoleResponse  storeRole(RoleRequest roleRequest);
}
