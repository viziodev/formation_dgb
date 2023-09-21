package com.dgb.formation_dgb.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("modelMapperImpl")
public class ModelMapperImpl  implements Mapper{
    ModelMapper modelMapper = new ModelMapper();
        @Override
       public    <E, R> List<R> map( List<E> entities,Class<R> targetClass ){
          return entities
                .stream()
                .map(entity-> modelMapper.map(entity,targetClass)
                )
                .collect(Collectors.toList());
      }

/*
  public static List<ArticleConfectionResponse> mapToActicleConfectionResponse(List<ArticleConfection> entities){

        return entities
                .stream()
                .map(ArticleConfectionResponse::toDto)
                .collect(Collectors.toList());
  }




    public static List<CategorieResponse> mapToCategorieResponse(List<Categorie> entities){
        return entities
                .stream()
                .map(CategorieResponse::toResponse)
                .collect(Collectors.toList());
    }

    public static List<UniteResponse> mapToUniteResponse(List<Unite> entities){
        return entities
                .stream()
                .map(UniteResponse::toDto)
                .collect(Collectors.toList());
    }

    public static List<ArticleConfectionResponse> mapToArticleConfectionResponse(List<ArticleConfection> entities){
        return entities
                .stream()
                .map(ArticleConfectionResponse::toDto)
                .collect(Collectors.toList());
    }

    public static List<FournisseurResponse> mapToFournisseurResponse(List<Fournisseur> entities){
        return entities
                .stream()
                .map(FournisseurResponse::toResponse)
                .collect(Collectors.toList());
    }
  */

}
