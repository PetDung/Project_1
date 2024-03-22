package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Product;
import com.ploy.polyshop.model.ProductStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements XRepository<Product, Integer> {

    MaterialRepository materialRepository = new MaterialRepository();
    ProductStatusRepository productStatusRepository = new ProductStatusRepository();

    String SQL_SELECT_BY_ID = "SELECT * FROM Product WHERE product_id = ?";
    String SQL_SELECT_BY_STATUS_ID = "SELECT * FROM Product WHERE status_id = ?";
    String SQL_FIND_BY_NAME = "SELECT * FROM Product WHERE product_name LIKE ? ";
    String SQL_SELECT_ALL = "SELECT * FROM Product";
    String SQL_UPDATE = "UPDATE Product\n"
            + "SET"
            + "    material_id = ?,"
            + "    status_id = ?,"
            + "    product_name = ?, "
            + "    created_at = ?,"
            + "    updated_at = ?,"
            + "    url_image = ?,"
            + "    description = ? "
            + "WHERE "
            + "    product_id = ?";
    String SQL_INSERT = "INSERT INTO Product (material_id, status_id, product_name, created_at, updated_at, url_image, description) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    String SQL_SELECT_NEW = "SELECT TOP 1 * FROM Product ORDER BY product_id DESC";
    

    @Override
    public void insert(Product entity) {
        DatBaseConnect.executeUpdate(SQL_INSERT,
                entity.getMaterial().getMaterialId(),
                entity.getStatus().getStatusId(),
                entity.getProductName(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getImageUrl(),
                entity.getDescription()
        );

    }

    @Override
    public void update(Product entity) {
        DatBaseConnect.executeUpdate(SQL_UPDATE,
                entity.getMaterial().getMaterialId(),
                entity.getStatus().getStatusId(),
                entity.getProductName(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getImageUrl(),
                entity.getDescription(),
                entity.getProductId()
        );
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Product selectById(Integer id) {
        List<Product> list = selectBySQL(SQL_SELECT_BY_ID, id);

        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Product> selectAll() {
        return selectBySQL(SQL_SELECT_ALL);
    }

    public List<Product> selectByStatus(Integer statusId) {
        return selectBySQL(SQL_SELECT_BY_STATUS_ID, statusId);
    }

    public List<Product> findByName(String name) {
        return selectBySQL(SQL_FIND_BY_NAME, "%" + name + "%");
    }
    
    public Product selectNewProductId (){
        return selectBySQL(SQL_SELECT_NEW).get(0);
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
                entity.setImageUrl(rs.getString("url_image"));

                int materialId = rs.getInt("material_id");
                entity.setMaterial(materialRepository.selectById(materialId));

                int statusId = rs.getInt("status_id");
                ProductStatus productStatus = productStatusRepository.selectById(statusId);
                entity.setStatus(productStatus);

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
