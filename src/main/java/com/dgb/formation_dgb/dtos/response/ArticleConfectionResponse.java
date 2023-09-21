package com.dgb.formation_dgb.dtos.response;

import com.dgb.formation_dgb.entities.ArticleConfection;
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
public class ArticleConfectionResponse {
    private Long id;
    private String libelle;
    private String reference;
    private double prix;
    private int qte;
    private CategorieResponse categorie;
    private UniteResponse unite;
    private List<FournisseurResponse> fournisseurs;

    public  static  ArticleConfectionResponse toDto(ArticleConfection response){
       return ArticleConfectionResponse
                .builder()
                .id(response.getId())
                .libelle(response.getLibelle())
                .reference(response.getReference())
                .prix(response.getPrix())
                .qte(response.getQteStock())
                .categorie(CategorieResponse.toResponse(response.getCategorie()))
                .unite(UniteResponse.toDto(response.getUnite()))
                .fournisseurs(response.getFournisseurs().stream()
                       .map(FournisseurResponse::toResponse)
                       .collect(Collectors.toList()))
                .build();
    }
}
