package com.dgb.formation_dgb.repositories;

import com.dgb.formation_dgb.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepository<T,ID> {
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "update  categories  c set c.etat=1 where c.id in (:ids)",nativeQuery = true)
    void restore(@Param("ids") List<Long> ids);
    @Query("Select c FROM  #{#entityName}  c  where c.id in :ids")
    List<Categorie>  restored(@Param("ids")List<Long> ids);
}
