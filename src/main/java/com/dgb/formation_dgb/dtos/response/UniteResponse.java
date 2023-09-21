package com.dgb.formation_dgb.dtos.response;

import com.dgb.formation_dgb.entities.Unite;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniteResponse {
    private Long id;
    private String libelle;
    private String code;

    public static UniteResponse  toDto(Unite response){
        return  UniteResponse.
                  builder()
                 .id(response.getId())
                 .code(response.getCode())
                 .libelle(response.getLibelle())
                  .build();

    }

}
