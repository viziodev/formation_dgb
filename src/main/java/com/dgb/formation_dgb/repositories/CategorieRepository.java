package com.dgb.formation_dgb.repositories;

import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.entities.projecction.CategorieProjection;
import com.dgb.formation_dgb.enums.CategorieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(excerptProjection = CategorieProjection.class)
public interface CategorieRepository extends BaseRepository<Categorie,Long>{
    @RestResource(path = "by-libelle")
    List<Categorie> findCategoriesByLibelleLike(String libelle);

    //JPQL
    @RestResource(path = "query-libelle")
    @Query("Select c From Categorie c where c.libelle like :lib")
    List<Categorie> byLibelle(@Param("lib") String libelle);

    //SQL Natif
    @RestResource(path = "native-libelle")
    @Query(value = "Select * From categories c where c.libelle like :libelle",nativeQuery = true)
    List<Categorie> byNativeQuery(String libelle);

    List<Categorie> findCategoriesByType(CategorieType type);

    //List<Categorie> findCategoriesByEtat(boolean etat);
         Page<Categorie> findCategoriesByEtat(Pageable page,boolean etat);

      Optional<Categorie> findByLibelle(String libelle);


}
