package com.ploy.polyshop.repository;

import com.ploy.polyshop.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements XRepository<Customer, Integer> {

    String SQL_SELECT_ALL = " SELECT * FROM Customer";
    String SQL_SELECT_BY_IS_ACTIVE = " SELECT * FROM Customer WHERE is_active = ?";
    String SQL_UPDATE = "UPDATE Customer SET customer_name=?,"
            + " address=?,"
            + " point=?,"
            + " phone_number=?,"
            + " is_active=?,"
            + " updated_at=? "
            + " WHERE customer_id=? ";
    String SQL_INSERT = "INSERT INTO Customer (customer_name, address, point, phone_number, is_active, updated_at, created_at) "
            + "VALUES (?, ?, ?, ?, ?, ?,?)";

    String SQL_SEARCH = "SELECT * FROM Customer "
            + "WHERE customer_name LIKE ? "
            + "OR phone_number LIKE ? ;";

    @Override
    public void insert(Customer entity) {
        DatBaseConnect.executeUpdate(SQL_INSERT,
                entity.getCustomerName(),
                entity.getAddress(),
                entity.getPoint(),
                entity.getPhoneNumber(),
                entity.isActive(),
                entity.getUpdatedAt(),
                entity.getCreatedAt()
        );

    }

    @Override
    public void update(Customer entity) {
        DatBaseConnect.executeUpdate(SQL_UPDATE,
                entity.getCustomerName(),
                entity.getAddress(),
                entity.getPoint(),
                entity.getPhoneNumber(),
                entity.isActive(),
                entity.getUpdatedAt(),
                entity.getCustomerId()
        );

    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Customer selectById(Integer id) {
        return null;
    }

    @Override
    public List<Customer> selectAll() {
        return selectBySQL(SQL_SELECT_ALL);
    }
    
    public List<Customer> search(String key){
        return selectBySQL(SQL_SEARCH, "%"+key+"%", "%"+key+"%");
    }
    
    public List<Customer> selectByIsActive(Boolean isActive){
        return selectBySQL(SQL_SELECT_BY_IS_ACTIVE, isActive);
    }

    @Override
    public List<Customer> selectBySQL(String sql, Object... args) {
        List<Customer> list = new ArrayList<>();
        try {
            ResultSet rs = DatBaseConnect.executeQuery(sql, args);
            while (rs.next()) {
                Customer entity = new Customer();

                entity.setCustomerId(rs.getInt("customer_id"));
                entity.setCustomerName(rs.getString("customer_name"));
                entity.setAddress(rs.getString("address"));
                entity.setPhoneNumber(rs.getString("phone_number"));
                entity.setPoint(rs.getInt("point"));
                entity.setUpdatedAt(rs.getDate("updated_at"));
                entity.setCreatedAt(rs.getDate("created_at"));
                entity.setActive(rs.getBoolean("is_active"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
