package com.dgb.formation_dgb.dtos.response;

import com.dgb.formation_dgb.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieResponse  {
    private Long id;
    private String libelle;



    public static   CategorieResponse toResponse(Categorie categorie) {
        return
                CategorieResponse
                        .builder()
                        .id(categorie.getId())
                        .libelle(categorie.getLibelle())
                        .build();
        //new CategorieResponse(categorie.getId(), categorie.getLibelle()) ;
    }




}
