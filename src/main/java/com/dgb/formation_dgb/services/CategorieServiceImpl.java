package com.dgb.formation_dgb.services;

import com.dgb.formation_dgb.dtos.response.CategorieResponse;
import com.dgb.formation_dgb.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class CategorieServiceImpl implements CategorieService {
    private CategorieRepository categorieRepository;
    @Override
    public List<CategorieResponse> restore(List<Long> ids) {
          categorieRepository.restore(ids);
        return categorieRepository.restored(ids)
                .stream().map(CategorieResponse::toResponse)
                .collect(Collectors.toList());
    }
}
