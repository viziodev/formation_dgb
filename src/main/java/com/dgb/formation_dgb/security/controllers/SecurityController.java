package com.dgb.formation_dgb.security.controllers;

import com.dgb.formation_dgb.security.dto.RoleRequest;
import com.dgb.formation_dgb.security.dto.UserRequest;
import com.dgb.formation_dgb.security.services.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/security")
@AllArgsConstructor
//@CrossOrigin("*")
public class SecurityController {
     private SecurityService securityService;

    @PostMapping("/users")
    public ResponseEntity<?> storeUser(@RequestBody UserRequest userRequest){

          return  new ResponseEntity<>(securityService.storeUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> allUser(){
       return  new ResponseEntity<>(securityService.allUser(), HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<?> storeRole(@RequestBody RoleRequest roleRequest){
       return  new ResponseEntity<>(securityService.storeRole(roleRequest), HttpStatus.CREATED);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> allRole(){
        return   new ResponseEntity<>(securityService.allRole(), HttpStatus.OK);
    }

}
