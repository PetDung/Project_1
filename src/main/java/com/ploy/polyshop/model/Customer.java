package com.ploy.polyshop.model;

import java.sql.Date;

public class Customer {
    private Integer customerId;
    private String customerName;
    private String address;
    private int point;
    private String phoneNumber;
    private boolean isActive;
    private Date updatedAt;
    private Date createdAt;

    public Customer() {
    }
    
    

    public Customer(Integer customerId, String customerName, String address, int point, String phoneNumber,
                    boolean isActive, Date updatedAt) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.point = point;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.updatedAt = updatedAt;
    }
    
    public Customer( String customerName, String address, int point, String phoneNumber,
                    boolean isActive, Date updatedAt, Date createdAt) {
        this.customerName = customerName;
        this.address = address;
        this.point = point;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Object[] getData() {
        Object[] data = new Object[7];
        data[0] = customerName;
        data[1] = address;
        data[2] = point;
        data[3] = phoneNumber;
        data[4] = isActive? "Đang hoạt động" : "Đã bị khóa";
        data[5] = updatedAt;
        data[6] = createdAt;

        return data;
    }
}
