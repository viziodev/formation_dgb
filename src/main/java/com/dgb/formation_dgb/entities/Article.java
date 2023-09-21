package com.dgb.formation_dgb.entities;


import com.dgb.formation_dgb.enums.CategorieType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discr")
@Table(name = "articles")
public class Article extends AbstractEnttity {
    @Column(nullable = false,unique = true)
    protected String libelle;
    @Column(nullable = false,unique = true)
    protected String reference;
    @Column(nullable = false,unique = true)
    protected double prix;
    @ManyToOne
    protected Categorie categorie;

    public Article(Long id, boolean etat, String libelle, String reference, double prix, Categorie categorie) {
        super(id, etat);
        this.libelle = libelle;
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

      public void generateReference(int ordre) {
        this.reference = String.format("REF_%s_%d",categorie.getLibelle()
                        .substring(0,3).toUpperCase(),ordre+1
                );
     }
}
