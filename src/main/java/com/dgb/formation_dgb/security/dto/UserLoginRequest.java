package com.dgb.formation_dgb.security.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class UserLoginRequest {
    private String username;
    private String password;
    private boolean refresh=false;
    private boolean withPassword=true;
    private String refreshToken="";
}
