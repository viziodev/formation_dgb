package com.dgb.formation_dgb.dtos.request;

import com.dgb.formation_dgb.entities.Categorie;
import com.dgb.formation_dgb.entities.Fournisseur;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FournisseurRequest implements RestRequest< Fournisseur>  {
    @NotNull(message="")
    private String name;
    @NotNull(message="")
    private String zone;

    @Override
    public Fournisseur toEntity() {
        return Fournisseur
                .builder()
                .name(this.name)
                .zone(this.zone)
                .build();
    }
}
