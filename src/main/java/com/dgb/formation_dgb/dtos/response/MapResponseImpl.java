package com.dgb.formation_dgb.dtos.response;

public abstract class MapResponseImpl<E,R> {
    public  abstract R  toDto(E entity);
}
