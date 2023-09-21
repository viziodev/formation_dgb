package com.dgb.formation_dgb.repositories;

import com.dgb.formation_dgb.entities.Article;
import com.dgb.formation_dgb.entities.ArticleConfection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Optional<Article> findArticleByLibelle(String libelle);

}
