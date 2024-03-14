package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Size;
import com.ploy.polyshop.model.Size;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeRepository implements XRepository<Size, Integer>{
    String SQL_SELECT_BY_ID = "SELECT * FROM Size WHERE size_id = ?";

    @Override
    public void insert(Size entity) {
    }

    @Override
    public void update(Size entity) {
    }

    @Override
    public void delete(Integer id) {
    }

   @Override
    public Size selectById(Integer id) {
        List<Size> list = selectBySQL(SQL_SELECT_BY_ID, id);
                
        return list.size()>0 ? list.get(0) : null; 
    }

    @Override
    public List<Size> selectAll() {
        return null;
    }

    @Override
    public List<Size> selectBySQL(String sql, Object... args) {
        
        List<Size> list = new ArrayList<>();
        try {
            ResultSet rs = DatBaseConnect.executeQuery(sql, args);
            while (rs.next()) {
                Size entity = new Size();

                entity.setSizeId(rs.getInt("size_id"));
                entity.setSizeName(rs.getString("size_name"));
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
