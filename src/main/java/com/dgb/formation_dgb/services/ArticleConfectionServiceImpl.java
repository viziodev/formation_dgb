package com.dgb.formation_dgb.services;

import com.dgb.formation_dgb.dtos.request.ArticleConfectionRequest;
import com.dgb.formation_dgb.dtos.response.*;
import com.dgb.formation_dgb.entities.*;
import com.dgb.formation_dgb.exceptions.custums.ApplicationException;
import com.dgb.formation_dgb.mappers.Mapper;
import com.dgb.formation_dgb.mappers.ModelMapperImpl;
import com.dgb.formation_dgb.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    private Mapper mapper;

    @Override
    public Article findArticleConfectionByLibelle(String libelle) {
        return articleRepository.findArticleByLibelle(libelle).orElse(null);
    }

    @Override
    public ArticleConfectionResponse store(ArticleConfectionRequest request) {
        Categorie categorie=categorieExist(request.getCategorie_id());
        Unite unite=uniteExist(request.getUnite_id());
        ArticleConfection articleConfection=request.toEntity();
        return save(request.getFournisseurs_ids(),articleConfection,unite,categorie);
    }

    @Override
    public ArticleConfectionLoadResponse load() {

// user here is a prepopulated User instance

        return ArticleConfectionLoadResponse
                .builder()
                .articleConfections(mapper.map( articleConfectionRepository.findAll(),ArticleConfectionResponse.class))
                .categories(mapper.map(categorieRepository.findAll(), CategorieResponse.class))
                .fournisseurs(mapper.map(fournisseurRepository.findAll(), FournisseurResponse.class))
                .articleConfections(mapper.map(articleConfectionRepository.findAll(),ArticleConfectionResponse.class))
                .unites(mapper.map(uniteRepository.findAll(), UniteResponse.class))
                .build();
    }

    @Override
    public ArticleConfectionResponse update(Long id, ArticleConfectionRequest request) {
           Categorie categorie=categorieExist(request.getCategorie_id());
           Unite unite=uniteExist(request.getUnite_id());
            Optional<ArticleConfection>  optionalArticleConfection= articleConfectionRepository.findById(id);
            if(optionalArticleConfection.isEmpty()){
                throw  new ApplicationException("article","Id not exist");
            }
        ArticleConfection articleConfection=optionalArticleConfection.get();
        articleConfection.setLibelle(request.getLibelle());
        articleConfection.setQteStock(request.getQte());
        articleConfection.setPrix(request.getPrix());

        return save(request.getFournisseurs_ids(),articleConfection,unite,categorie);
    }

    private Categorie categorieExist(Long idCategorie){
        Optional<Categorie> optCat = categorieRepository.findById(idCategorie);
        if(optCat.isEmpty()){
            throw new ApplicationException("Identifiant inexistant");
        }
        return optCat.get();
    }

    private Unite uniteExist(Long idUnite){
        Optional<Unite> optUnite = uniteRepository.findById(idUnite);
        if(optUnite.isEmpty()){
            throw new ApplicationException("unite","Identifiant inexistant");
        }
        return optUnite.get();
    }
    private ArticleConfectionResponse save(List<Long> idsFour,ArticleConfection articleConfection,Unite unite,Categorie categorie){

        List<Fournisseur> fournisseurs = idsFour
                .stream()
                .map(idFour -> fournisseurRepository.findById(idFour).orElse(null))
                .filter(four -> four != null)
                .collect(Collectors.toList());


        articleConfection.setCategorie(categorie);
        articleConfection.setUnite(unite);
        articleConfection.setFournisseurs(fournisseurs);
        articleConfection.generateReference(categorie.getArticles().size());
        return ArticleConfectionResponse.toDto(articleConfectionRepository.save(articleConfection));
    }
}
