package com.dgb.formation_dgb.controllers.rest;

import com.dgb.formation_dgb.services.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FournisseurController {
    private FournisseurService fournisseurService;

    public ResponseEntity<?> all(){

        return null;
    }
}
