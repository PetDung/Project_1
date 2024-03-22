package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Size;
import com.ploy.polyshop.model.Size;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeRepository implements XRepository<Size, Integer>{
    String SQL_SELECT_BY_ID = "SELECT * FROM Size WHERE size_id = ?";
    String SQL_SELECT_ALL = "SELECT * FROM Size";
    String SQL_UPDATE = "UPDATE Size SET size_name = ?, description = ?, is_active = ?, updated_at = ? WHERE size_id = ?";
    String SQL_INSERT = "INSERT INTO Size (size_name, description, is_active, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
    String SQL_SELECT_BY_NAME = "SELECT * FROM Size WHERE size_name LIKE ?";



    
    
    @Override
    public void insert(Size entity) {
        DatBaseConnect.executeUpdate(SQL_INSERT,
                entity.getSizeName(),
                entity.getDescription(),
                entity.isIsActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    @Override
    public void update(Size entity) {
        
        DatBaseConnect.executeUpdate(SQL_UPDATE,
                entity.getSizeName(),
                entity.getDescription(),
                entity.isIsActive(),
                entity.getUpdatedAt(),
                entity.getSizeId()
        );
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
        return selectBySQL(SQL_SELECT_ALL);
    }
    
    public  List<Size> findByName(String name){
        return selectBySQL(SQL_SELECT_BY_NAME, "%" + name + "%");
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
