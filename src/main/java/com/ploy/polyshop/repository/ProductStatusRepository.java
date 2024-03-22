package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.ProductStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductStatusRepository implements XRepository<ProductStatus, Integer>{
    
    String SQL_SELECT_ALL ="SELECT * FROM ProductStatus";
    String SQL_SELECT_BY_ID ="SELECT * FROM ProductStatus WHERE status_id = ?";
    
    
    @Override
    public void insert(ProductStatus entity) {
    }

    @Override
    public void update(ProductStatus entity) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public ProductStatus selectById(Integer id) {
       List<ProductStatus> list = selectBySQL(SQL_SELECT_BY_ID, id);
                
      return list.size()>0 ? list.get(0) : null; 
    }

    @Override
    public List<ProductStatus> selectAll() {
        return selectBySQL(SQL_SELECT_ALL);
    }

    @Override
    public List<ProductStatus> selectBySQL(String sql, Object... args) {
        List<ProductStatus> list = new ArrayList<>();
        
        try {
            ResultSet rs = DatBaseConnect.executeQuery(sql, args);
            while (rs.next()) {
                ProductStatus entity = new ProductStatus();

                entity.setStatusId(rs.getInt("status_id"));
                entity.setStatusName(rs.getString("status_name"));
                entity.setDescription(rs.getString("description"));
                entity.setUpdatedAt(rs.getDate("updated_at"));
                entity.setCreatedAt(rs.getDate("created_at"));
                entity.setIsActive(rs.getBoolean("is_active"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return list;
    }
    
}
