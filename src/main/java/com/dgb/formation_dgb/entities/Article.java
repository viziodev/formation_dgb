package com.dgb.formation_dgb.entities;


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
    protected double prix;
    @ManyToOne
    protected Categorie categorie;



}
