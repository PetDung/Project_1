package com.ploy.polyshop.model;

import java.sql.Date;

public class ProductDetail {
    private int productDetailsId;
    private Color color;
    private Size size;
    private Product product;
    private int discountId;
    private int status;
    private double price;
    private String quantity;
    private String imageUrl;
    private Date createdAt;
    private Date updatedAt;

    // Constructor
   
    public ProductDetail(int productDetailsId, Color color, Size size, Product product, int discountId, int status, double price, String quantity, String imageUrl, Date createdAt, Date updatedAt) {
        this.productDetailsId = productDetailsId;
        this.color = color;
        this.size = size;
        this.product = product;
        this.discountId = discountId;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ProductDetail() {
    }

    public int getProductDetailsId() {
        return productDetailsId;
    }

    public void setProductDetailsId(int productDetailsId) {
        this.productDetailsId = productDetailsId;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
    
    
    
    
    

    // Method to convert to Object array
    public Object[] toData() {
        Object[] data = new Object[4];
        data[0] = product.getProductName() + product.getMaterial().getMaterialName();
        data[1] = color.getColorName();
        data[2] = size.getSizeName();
        data[3] = "0";
//        data[4] = discountId;
//        data[5] = statusId;
//        data[6] = price;
//        data[7] = quantity;
//        data[8] = imageUrl;
//        data[9] = createdAt;
//        data[10] = updatedAt;
        return data;
    }
}
