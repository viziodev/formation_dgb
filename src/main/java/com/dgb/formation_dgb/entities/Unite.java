package com.dgb.formation_dgb.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unites")
@SQLDelete(sql = "update unites set etat=0 where id=? ")
public class Unite extends AbstractEnttity{
    @Column(nullable = false,unique = true)
    protected String libelle;
    @Column(nullable = false,unique = true)
    protected String code;
    @OneToMany(mappedBy = "unite")
    private List<ArticleConfection> articleConfections;

    public Unite(Long id) {
        super(id);
    }
}
