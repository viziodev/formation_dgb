package com.dgb.formation_dgb.services;

import com.dgb.formation_dgb.dtos.request.ArticleConfectionRequest;
import com.dgb.formation_dgb.dtos.response.ArticleConfectionLoadResponse;
import com.dgb.formation_dgb.dtos.response.ArticleConfectionResponse;
import com.dgb.formation_dgb.entities.Article;

public interface ArticleConfectionService {
    Article findArticleConfectionByLibelle(String libelle);
    ArticleConfectionResponse store (ArticleConfectionRequest request);
    ArticleConfectionLoadResponse load();

    ArticleConfectionResponse update(Long id, ArticleConfectionRequest request);
}
