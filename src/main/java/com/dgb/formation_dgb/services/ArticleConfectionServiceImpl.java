package com.dgb.formation_dgb.services;

import com.dgb.formation_dgb.dtos.request.ArticleConfectionRequest;
import com.dgb.formation_dgb.dtos.response.ArticleConfectionLoadResponse;
import com.dgb.formation_dgb.dtos.response.ArticleConfectionResponse;
import com.dgb.formation_dgb.entities.*;
import com.dgb.formation_dgb.enums.CategorieType;
import com.dgb.formation_dgb.mappers.Mapper;
import com.dgb.formation_dgb.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ArticleConfectionServiceImpl implements ArticleConfectionService {
    private ArticleRepository articleRepository;
    private ArticleConfectionRepository articleConfectionRepository;
    private CategorieRepository categorieRepository;
    private UniteRepository uniteRepository;
    private FournisseurRepository fournisseurRepository;
    @Override
    public Article findArticleConfectionByLibelle(String libelle) {
        return articleRepository.findArticleByLibelle(libelle).orElse(null);
    }

    @Override
    public ArticleConfectionResponse store(ArticleConfectionRequest request) {
        Optional<Categorie> optCat = categorieRepository.findById(request.getCategorie_id());
        if(optCat.isEmpty()){
            throw new RuntimeException("Identifiant inexistant");
        }
        Optional<Unite> optUnite = uniteRepository.findById(request.getUnite_id());
        if(optUnite.isEmpty()){
            throw new RuntimeException("Identifiant inexistant");
        }
        List<Fournisseur> fournisseurs = request.getFournisseurs_ids()
                .stream()
                .map(idFour -> fournisseurRepository.findById(idFour).orElse(null))
                .filter(four -> four != null)
                .collect(Collectors.toList());
        Categorie categorie= optCat.get();
        ArticleConfection articleConfection=request.toEntity();
        articleConfection.setCategorie(optCat.get());
        articleConfection.setUnite(optUnite.get());
        articleConfection.setFournisseurs(fournisseurs);
        articleConfection.generateReference(categorie.getArticles().size());
        return ArticleConfectionResponse.toDto(articleConfectionRepository.save(articleConfection));
    }

    @Override
    public ArticleConfectionLoadResponse load() {
        return ArticleConfectionLoadResponse
                .builder()
                .articleConfections(Mapper.mapToActicleConfectionResponse( articleConfectionRepository.findAll()))
                .categories(Mapper.mapToCategorieResponse(categorieRepository.findAll()))
                .fournisseurs(Mapper.mapToFournisseurResponse(fournisseurRepository.findAll()))
                .articleConfections(Mapper.mapToArticleConfectionResponse(articleConfectionRepository.findAll()))
                .unites(Mapper.mapToUniteResponse(uniteRepository.findAll()))
                .build();
    }
}
