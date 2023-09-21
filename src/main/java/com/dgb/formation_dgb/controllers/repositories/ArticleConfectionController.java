package com.dgb.formation_dgb.controllers.repositories;


import com.dgb.formation_dgb.dtos.request.ArticleConfectionRequest;
import com.dgb.formation_dgb.dtos.response.ArticleConfectionLoadResponse;
import com.dgb.formation_dgb.dtos.response.ArticleConfectionResponse;
import com.dgb.formation_dgb.entities.Article;
import com.dgb.formation_dgb.entities.ArticleConfection;
import com.dgb.formation_dgb.services.ArticleConfectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/article-confection")
@AllArgsConstructor
public class ArticleConfectionController {
   private ArticleConfectionService articleConfectionService;
    @GetMapping("/search")
    public ResponseEntity<Article> findArticleConfectionByLibelle(@RequestParam(value = "")String keyword ){
        Article articleConfection = articleConfectionService.findArticleConfectionByLibelle(keyword);
        return ResponseEntity.ok(articleConfection);
    }
    @GetMapping("")
    public ResponseEntity<ArticleConfectionLoadResponse> load(){
        ArticleConfectionLoadResponse articleConfection = articleConfectionService.load();
        return ResponseEntity.ok(articleConfection);
    }

    @PostMapping("")
    public ResponseEntity<ArticleConfectionResponse> store(@RequestBody ArticleConfectionRequest request){
        return new ResponseEntity<>(articleConfectionService.store(request), HttpStatus.CREATED);
    }

}
