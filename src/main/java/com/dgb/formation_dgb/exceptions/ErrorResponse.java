package com.dgb.formation_dgb.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private Map<String, String> errors;
}
