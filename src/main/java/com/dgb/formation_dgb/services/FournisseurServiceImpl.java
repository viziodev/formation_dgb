package com.dgb.formation_dgb.services;

import com.dgb.formation_dgb.dtos.request.FournisseurRequest;
import com.dgb.formation_dgb.dtos.response.FournisseurResponse;
import com.dgb.formation_dgb.entities.Fournisseur;
import com.dgb.formation_dgb.repositories.FournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;
    @Override
    public List<FournisseurResponse> all() {
        return null;
    }

    @Override
    public Page<FournisseurResponse> all(Pageable page, String zone) {
        return fournisseurRepository.findFournisseurByEtat_TrueAndZone(page,zone)
                .map(FournisseurResponse::toResponse);
    }

    @Override
    public Page<FournisseurResponse> all(Pageable page) {
        return fournisseurRepository.findFournisseurByEtat_True(page)
                .map(FournisseurResponse::toResponse);
    }

    @Override
    public FournisseurResponse byId(Long id) {
          return fournisseurRepository
                  .findById(id)
                  .map(FournisseurResponse::toResponse)
                  .orElseThrow(()->new RuntimeException("Id.."));

    }

    @Override
    public FournisseurResponse store(FournisseurRequest request) {
          return FournisseurResponse
                  .toResponse(fournisseurRepository
                   .save(request.toEntity()));

    }
}
