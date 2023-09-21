package com.dgb.formation_dgb.exceptions.custums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException{
    private  String key="field";
    private HttpStatus httpStatus=HttpStatus.NOT_FOUND;

    public ApplicationException(String message) {
        super(message);

    }

    public ApplicationException(String key, String message) {
        super(message);
        this.key = key;
    }
}
