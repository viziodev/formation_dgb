package com.dgb.formation_dgb.dtos.response;

import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.entities.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FournisseurResponse  {
    private Long id;
    private String name;
    private String zone;
    public static   FournisseurResponse toResponse(Fournisseur fournisseur) {
        return FournisseurResponse.
                builder()
                .id(fournisseur.getId())
                .name(fournisseur.getName())
                .zone(fournisseur.getZone())
                .build();
      }
}


