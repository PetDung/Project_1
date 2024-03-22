
package com.ploy.polyshop.model;

import java.sql.Date;

public class Product {
    private Integer productId;
    private Material material;
    private ProductStatus status;
    private String productName;
    private Date createdAt;
    private Date updatedAt;
    private String imageUrl;
    private String description;

    public Product(int productId, Material material, ProductStatus status, String productName, Date createdAt, Date updatedAt, String imageUrl, String description) {
        this.productId = productId;
        this.material = material;
        this.status = status;
        this.productName = productName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
 
}


