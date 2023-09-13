package com.dgb.formation_dgb.dtos.request;

import com.dgb.formation_dgb.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieRequest implements RestRequest<Categorie>  {

    private List<Long > categoriesId;

    @Override
    public Categorie toEntity() {
        return null;
    }
}
