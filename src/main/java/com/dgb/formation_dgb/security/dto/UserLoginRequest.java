package com.dgb.formation_dgb.dtos.request;

import lombok.Data;
import lombok.Getter;

public record UserLoginRequest(String username,String password) {
}
