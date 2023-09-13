package com.dgb.formation_dgb.dtos.request;

public interface RestRequest<Entity> {
    Entity toEntity();
}
