package com.dgb.formation_dgb.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleConfectionLoadResponse {
    private List<UniteResponse> unites;
    private List<CategorieResponse> categories;
    private List<FournisseurResponse> fournisseurs;
    private List<ArticleConfectionResponse> articleConfections;
}
