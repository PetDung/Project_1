package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Color;
import com.ploy.polyshop.model.Size;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorRepository implements XRepository<Color, Integer> {

    String SQL_SELECT_BY_ID = "SELECT * FROM Color WHERE color_id = ?";
    String SQL_SELECT_ALL = "SELECT * FROM Color";
    String SQL_UPDATE = "UPDATE Color SET color_name = ?, description = ?, is_active = ?, updated_at = ? WHERE color_id = ?";
    String SQL_INSERT = "INSERT INTO Color (color_name, description, is_active, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
    String SQL_SELECT_BY_NAME = "SELECT * FROM Color WHERE color_name LIKE ?";


    @Override
    public void insert(Color entity) {
        System.out.println(entity.isIsActive());
        DatBaseConnect.executeUpdate(SQL_INSERT,
                entity.getColorName(),
                entity.getDescription(),
                entity.isIsActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    @Override
    public void update(Color entity) {
        DatBaseConnect.executeUpdate(SQL_UPDATE,
                entity.getColorName(),
                entity.getDescription(),
                entity.isIsActive(),
                entity.getUpdatedAt(),
                entity.getColorId()
        );
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Color selectById(Integer id) {
        List<Color> list = selectBySQL(SQL_SELECT_BY_ID, id);

        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Color> selectAll() {
        return selectBySQL(SQL_SELECT_ALL);
    }
    public  List<Color> findByName(String name){
        return selectBySQL(SQL_SELECT_BY_NAME, "%" + name + "%");
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
