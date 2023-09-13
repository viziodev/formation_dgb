package com.dgb.formation_dgb;

import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.enums.CategorieType;
import com.dgb.formation_dgb.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormationDgbApplication implements CommandLineRunner {

    @Autowired
    CategorieRepository categorieRepository;

    public static void main(String[] args) {
        SpringApplication.run(FormationDgbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
      // categorieRepository.save(new Categorie("AV1", CategorieType.Vente)) ;

    }
}
