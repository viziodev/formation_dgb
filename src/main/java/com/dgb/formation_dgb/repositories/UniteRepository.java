package com.dgb.formation_dgb.repositories;

import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.entities.Unite;
import com.dgb.formation_dgb.entities.projecction.CategorieProjection;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
@RepositoryRestResource(path ="unites")
public interface UniteRepository extends BaseRepository<Unite,Long>{
}
