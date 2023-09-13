package com.dgb.formation_dgb.dtos.response;

import com.dgb.formation_dgb.entities.Categorie;

import java.util.List;

public interface RestResponse<Entity, Response>{
    Response toResponse(Entity entity);
    List<Response> toResponseList(List<Entity> list);
}
