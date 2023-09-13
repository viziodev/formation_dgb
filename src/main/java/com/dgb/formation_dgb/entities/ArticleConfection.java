package com.dgb.formation_dgb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue(value = "AC")
public class ArticleConfection extends  Article {
    @Column(nullable = false)
    private  int qteStock;
    @OneToMany(mappedBy = "articleConfection")
    List<ACAV> acavs;
}
