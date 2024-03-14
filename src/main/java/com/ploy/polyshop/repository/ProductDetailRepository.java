package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Color;
import com.ploy.polyshop.model.Customer;
import com.ploy.polyshop.model.Product;
import com.ploy.polyshop.model.ProductDetail;
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
    
    
    
    @Override
    public void insert(ProductDetail entity) {
    }

    @Override
    public void update(ProductDetail entity) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public ProductDetail selectById(Integer id) {
        
        return  null;
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
                Product product = productRepository.selectById(sizeId);
                
                int discountId = rs.getInt("discount_id");
                
                int statusId = rs.getInt("status_id");
                
                double price = rs.getDouble("price");
                String quantity = rs.getString("quantity");
                String imageUrl = rs.getString("url_image");
                Date createdAt = rs.getDate("created_at");
                Date updatedAt = rs.getDate("updated_at");
                
                ProductDetail entity = new ProductDetail(productDetailsId, color, size, product, discountId, statusId, price, quantity, imageUrl, createdAt, updatedAt);
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
