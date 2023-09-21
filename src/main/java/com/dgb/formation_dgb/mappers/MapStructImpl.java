package com.dgb.formation_dgb.mappers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//@Qualifier("mapStructImpl")
public class MapStructImpl implements Mapper{
    @Override
    public <E, R> List<R> map(List<E> entities, Class<R> targetClass) {
        return null;
    }
}
