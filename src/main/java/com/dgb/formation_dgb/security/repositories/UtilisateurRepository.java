package com.dgb.formation_dgb.security.repositories;

import com.dgb.formation_dgb.repositories.BaseRepository;
import com.dgb.formation_dgb.security.entities.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends BaseRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUsername(String username);
}
