package com.dgb.formation_dgb.entities.projecction;

import com.dgb.formation_dgb.entities.Categorie;
import org.springframework.data.rest.core.config.Projection;

@Projection(name ="p1",types = Categorie.class)
public interface CategorieProjection {
    Long getId();
    String getLibelle();
    boolean getEtat();

}
