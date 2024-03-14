package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Material;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialRepository  implements XRepository<Material, Integer>{
    
    String SQL_SELECT_BY_ID = "SELECT * FROM Material WHERE material_id = ?";
    
    
    @Override
    public void insert(Material entity) {
    }

    @Override
    public void update(Material entity) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Material selectById(Integer id) {
        List<Material> list = selectBySQL(SQL_SELECT_BY_ID, id);
                
        return list.size()>0 ? list.get(0) : null; 
    }

    @Override
    public List<Material> selectAll() {
        return null;
    }

    @Override
    public List<Material> selectBySQL(String sql, Object... args) {
        
        List<Material> list = new ArrayList<>();
        try {
            ResultSet rs = DatBaseConnect.executeQuery(sql, args);
            while (rs.next()) {
                Material entity = new Material();

                entity.setMaterialId(rs.getInt("material_id"));
                entity.setMaterialName(rs.getString("material_name"));
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
