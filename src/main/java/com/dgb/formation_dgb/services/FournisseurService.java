package com.dgb.formation_dgb.services;

import com.dgb.formation_dgb.dtos.request.FournisseurRequest;
import com.dgb.formation_dgb.dtos.response.FournisseurResponse;
import com.dgb.formation_dgb.entities.Fournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FournisseurService {
    List<FournisseurResponse> all();
    Page<FournisseurResponse> all(Pageable page,String zone);
    Page<FournisseurResponse> all(Pageable page);
    FournisseurResponse byId(Long id);
    FournisseurResponse store(FournisseurRequest request);

}
