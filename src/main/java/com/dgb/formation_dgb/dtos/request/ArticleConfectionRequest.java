package com.dgb.formation_dgb.dtos.request;

import com.dgb.formation_dgb.entities.ArticleConfection;
import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.entities.Unite;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleConfectionRequest implements RestRequest<ArticleConfection> {
    private String libelle;
    private double prix;
    private int qte;
    private Long categorie_id;
    private Long unite_id;
    private List<Long> fournisseurs_ids;

    @Override
    public ArticleConfection toEntity() {
        return ArticleConfection
                .builder()
                .qteStock(qte)
                .unite(new Unite(unite_id))
                .prix(prix)
                .libelle(libelle)
                .build();
    }
}
