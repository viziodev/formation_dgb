package com.dgb.formation_dgb.dtos.request;

import com.dgb.formation_dgb.entities.ArticleConfection;
import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.entities.Unite;
import com.dgb.formation_dgb.validators.ListIdExistConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleConfectionRequest implements RestRequest<ArticleConfection> {
    @NotEmpty(message = "Le libelle est obligatoire")
    @Size(min = 5, message = "Le libelle est doit contenir au moins 5 caractere")
    private String libelle;
    @NotNull(message = "Le PrixAchat est obligatoire")
    @Positive(message = "Le PrixAchat est positif")

    private double prix;
    @NotNull(message = "Le Qte est obligatoire")
    @Positive(message = "Le Qte en Stock  est positif")
    @Min(100)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int qte;
    @NotNull(message = "La Categorie est obligatoire")
    @Positive(message = "L'identifiant de la Categorie")
    private Long categorie_id;
    @NotNull(message = "L'unite est obligatoire")
    @Positive(message = "L'identifiant de l'unite")
    private Long unite_id;
    @NotEmpty(message = "Veuillez selectionnez au moins un fournisseur")
    @ListIdExistConstraint
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
