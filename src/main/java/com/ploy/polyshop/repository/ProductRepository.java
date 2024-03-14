package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository implements XRepository<Product, Integer>{
    
    MaterialRepository materialRepository = new MaterialRepository();
    
    String SQL_SELECT_BY_ID = "SELECT * FROM Product WHERE product_id = ?";

    @Override
    public void insert(Product entity) {
    }

    @Override
    public void update(Product entity) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Product selectById(Integer id) {
        List<Product> list = selectBySQL(SQL_SELECT_BY_ID, id);
                
        return list.size()>0 ? list.get(0) : null; 
    }

    @Override
    public List<Product> selectAll() {
        return null;
    }

    @Override
    public List<Product> selectBySQL(String sql, Object... args) {
        
        List<Product> list = new ArrayList<>();
        try {
            ResultSet rs = DatBaseConnect.executeQuery(sql, args);
            while (rs.next()) {
                Product entity = new Product();

                entity.setProductId(rs.getInt("product_id"));
                entity.setProductName(rs.getString("product_name"));
                entity.setDescription(rs.getString("description"));
                
                int materialId = rs.getInt("material_id");
                entity.setMaterial(materialRepository.selectById(materialId));
                
                
                entity.setUpdatedAt(rs.getDate("updated_at"));
                entity.setCreatedAt(rs.getDate("created_at"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
