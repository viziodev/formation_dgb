package com.dgb.formation_dgb.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ACAV extends AbstractEnttity{
    private int qte;

    @ManyToOne
    private  ArticleConfection  articleConfection;
    @ManyToOne
    private  ArticleVente articleVente;
}
