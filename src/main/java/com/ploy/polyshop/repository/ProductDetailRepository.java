package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Color;
import com.ploy.polyshop.model.Customer;
import com.ploy.polyshop.model.Product;
import com.ploy.polyshop.model.ProductDetail;
import com.ploy.polyshop.model.ProductStatus;
import com.ploy.polyshop.model.Size;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailRepository implements XRepository<ProductDetail, Integer>{
    
    ColorRepository colorRepository = new ColorRepository();
    SizeRepository sizeRepository = new SizeRepository();
    ProductRepository productRepository = new ProductRepository();
    
    String SQL_SELECT_ALL = "SELECT * FROM ProductDetails";
    String SQL_SELECT_BY_PRODUCT = "SELECT * FROM ProductDetails WHERE product_id = ?";
    String SQL_UPDATE = "UPDATE ProductDetails " +
                    "SET " +
                    "color_id = ?, " +
                    "size_id = ?, " +
                    "product_id = ?, " +
                    "discount_id = ?, " +
                    "status_id = ?, " +
                    "price = ?, " +
                    "quantity = ?, " +
                    "url_image = ?, " +
                    "updated_at = ? " +
                    "WHERE " +
                    "product_details_id = ?";
    String SQL_INSERT = "INSERT INTO ProductDetails (color_id, size_id, product_id, discount_id, status_id, price, quantity, url_image, updated_at, created_at) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    
    
    
    @Override
    public void insert(ProductDetail entity) {
        DatBaseConnect.executeUpdate(SQL_INSERT,
                entity.getColor().getColorId(),
                entity.getSize().getSizeId(),
                entity.getProduct().getProductId(),
                null,
                entity.getStatus().getStatusId(),
                entity.getPrice(),
                entity.getQuantity(),
                entity.getImageUrl(),
                entity.getUpdatedAt(),
                entity.getCreatedAt()
                );
    }

    @Override
    public void update(ProductDetail entity) {
        DatBaseConnect.executeUpdate(SQL_UPDATE,
                 entity.getColor().getColorId(),
                 entity.getSize().getSizeId(),
                 entity.getProduct().getProductId(),
                 null,
                 entity.getStatus().getStatusId(),
                 entity.getPrice(),
                 entity.getQuantity(),
                 entity.getImageUrl(),
                 entity.getUpdatedAt(),
                 entity.getProductDetailsId()
                 
                );
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public ProductDetail selectById(Integer id) {
        
        return  null;
    }
    
    public List<ProductDetail> selectByProduct(Integer id){
        System.out.println("Id tìm:" + id);
        return  selectBySQL(SQL_SELECT_BY_PRODUCT, id);
    }

    @Override
    public List<ProductDetail> selectAll() {
        return  selectBySQL(SQL_SELECT_ALL);
    }

    @Override
    public List<ProductDetail> selectBySQL(String sql, Object... args) {
        
        List<ProductDetail> list = new ArrayList<>();
        try {
            ResultSet rs = DatBaseConnect.executeQuery(sql, args);
            while (rs.next()) {
                int productDetailsId = rs.getInt("product_details_id");
                
                int colorId = rs.getInt("color_id");
                Color color = colorRepository.selectById(colorId);
                
                int sizeId = rs.getInt("size_id");
                Size size = sizeRepository.selectById(sizeId);
                
                int productId = rs.getInt("product_id");
                Product product = productRepository.selectById(productId);
                
                int discountId = rs.getInt("discount_id");
                
                int statusId = rs.getInt("status_id");
                ProductStatus status = new ProductStatusRepository().selectById(statusId);
                
                double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                String imageUrl = rs.getString("url_image");
                Date createdAt = rs.getDate("created_at");
                Date updatedAt = rs.getDate("updated_at");
                
                ProductDetail entity = new ProductDetail(productDetailsId, color, size, product, discountId, status, price, quantity, imageUrl, createdAt, updatedAt);
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
