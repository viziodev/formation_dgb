package com.dgb.formation_dgb.exceptions.custums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApplicationExeption extends RuntimeException{
    private  String key="field";
    private HttpStatus httpStatus=HttpStatus.NOT_FOUND;

    public ApplicationExeption(String message) {
        super(message);

    }

    public  ApplicationExeption(String key,String message) {
        super(message);
        this.key = key;
    }
}
