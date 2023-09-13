package com.dgb.formation_dgb.repositories;

import com.dgb.formation_dgb.entities.Fournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface FournisseurRepository extends BaseRepository<Fournisseur,Long> {
    Page<Fournisseur> findFournisseurByEtat_True(Pageable pageable);
    Page<Fournisseur> findFournisseurByEtat_TrueAndZone(Pageable pageable,String zone);
}
