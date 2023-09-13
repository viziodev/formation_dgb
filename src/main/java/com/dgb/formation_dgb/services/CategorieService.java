package com.dgb.formation_dgb.services;

import com.dgb.formation_dgb.dtos.response.CategorieResponse;

import java.util.List;

public interface CategorieService {
    List<CategorieResponse> restore(List<Long> ids);
}
