package com.dgb.formation_dgb.entities;

import com.dgb.formation_dgb.enums.CategorieType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
@SQLDelete(sql = "update categories set etat=0 where id=? ")
//@Where(clause = "etat=1")

public class Categorie extends AbstractEnttity {

    @Column(nullable = false,unique = true)
    private String libelle;

    @Enumerated(EnumType.STRING)
    private CategorieType type;

    public Categorie(String libelle, CategorieType type) {
        this.libelle = libelle;
        this.type = type;
    }

    @ManyToMany
   // @JoinTable
    //Attributs Navigationnels
    List<Fournisseur> fournisseurs;
    @OneToMany(mappedBy = "categorie")
    List<Article> articles;

}
