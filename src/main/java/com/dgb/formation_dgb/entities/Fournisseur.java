package com.dgb.formation_dgb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "fournisseurs")
@SQLDelete(sql = "update fournisseurs set etat=0 where id=? ")
public class Fournisseur extends  AbstractEnttity {
    private String name;
    @Column(length = 20)
   // @Transient
    private String zone;
    @ManyToMany(mappedBy = "fournisseurs")
    List<Categorie> categories;
}
