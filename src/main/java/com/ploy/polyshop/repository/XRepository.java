package com.ploy.polyshop.repository;

import java.util.List;

public interface XRepository<EntityType,Type> {
    
    void insert(EntityType entity);

    void update(EntityType entity);

    void delete(Type id);

    EntityType selectById(Type id);

    List<EntityType> selectAll();

    List<EntityType> selectBySQL(String sql, Object... args);  
    
}