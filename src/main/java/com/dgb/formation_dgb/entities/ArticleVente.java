package com.dgb.formation_dgb.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue(value = "AV")
public class ArticleVente extends Article {
    @Transient
    private double cout;
   // @Column(nullable = false)
    private boolean promo=false ;
    private double valeur=0 ;

    @OneToMany(mappedBy = "articleVente")
    List<ACAV> acavs;

}
