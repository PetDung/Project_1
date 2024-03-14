
package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorRepository  implements XRepository<Color, Integer>{
    
    String SQL_SELECT_BY_ID = "SELECT * FROM Color WHERE color_id = ?";
    
    
    @Override
    public void insert(Color entity) {
    }

    @Override
    public void update(Color entity) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Color selectById(Integer id) {
        List<Color> list = selectBySQL(SQL_SELECT_BY_ID, id);
                
        return list.size()>0 ? list.get(0) : null; 
    }

    @Override
    public List<Color> selectAll() {
        return null;
    }

    @Override
    public List<Color> selectBySQL(String sql, Object... args) {
        
        List<Color> list = new ArrayList<>();
        try {
            ResultSet rs = DatBaseConnect.executeQuery(sql, args);
            while (rs.next()) {
                Color entity = new Color();

                entity.setColorId(rs.getInt("color_id"));
                entity.setColorName(rs.getString("color_name"));
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
