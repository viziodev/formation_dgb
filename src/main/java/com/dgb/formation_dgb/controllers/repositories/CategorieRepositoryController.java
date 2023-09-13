package com.dgb.formation_dgb.controllers.repositories;

import com.dgb.formation_dgb.dtos.request.CategorieRequest;
import com.dgb.formation_dgb.dtos.response.CategorieResponse;
import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.repositories.CategorieRepository;
import com.dgb.formation_dgb.services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RepositoryRestController
@AllArgsConstructor
public class CategorieRepositoryController {
  private CategorieRepository categorieRepository;
  private CategorieService categorieService;

  @GetMapping("/categories")
  public ResponseEntity<?> all(PagedResourcesAssembler resourcesAssembler){
        Page<CategorieResponse> categories =
              categorieRepository
              .findCategoriesByEtat(Pageable.ofSize(2),true)
              .map(CategorieResponse::toResponse);
      PagedModel<EntityModel<CategorieResponse>> pagedModel = resourcesAssembler.toModel(categories);
        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
  }
    public  Categorie byId(){
        return null;
    }

    @DeleteMapping("/categories")
    public ResponseEntity<?> removeAll(@RequestBody CategorieRequest request){
        request.getCategoriesId().forEach(idCat->{
            categorieRepository.deleteById(idCat);
        });
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/categories/restore")
    public ResponseEntity<?> restore(@RequestBody CategorieRequest request){
        return new ResponseEntity<>(categorieService.restore(request.getCategoriesId()), HttpStatus.OK);
    }

}
