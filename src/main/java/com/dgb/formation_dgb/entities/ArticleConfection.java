package com.dgb.formation_dgb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue(value = "AC")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleConfection extends  Article {
    @Column(nullable = false)
    private  int qteStock;
    @OneToMany(mappedBy = "articleConfection")
    List<ACAV> acavs;

    @ManyToOne()
    private Unite unite;

    @ManyToMany
    List<Fournisseur> fournisseurs;

    @Builder
    public ArticleConfection(Long id, boolean etat, String libelle, String reference, double prix, Categorie categorie, int qteStock, List<ACAV> acavs, Unite unite, List<Fournisseur> fournisseurs) {
        super(id, etat, libelle, reference, prix, categorie);
        this.qteStock = qteStock;
        this.acavs = acavs;
        this.unite = unite;
        this.fournisseurs = fournisseurs;
    }
}
