package com.dgb.formation_dgb.mappers;

import java.util.List;

public interface Mapper {
    <E, R> List<R> map(List<E> entities, Class<R> targetClass );
}
