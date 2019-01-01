package com.yang4j.servletlearn.service;

import com.yang4j.servletlearn.model.Customer;
import com.yang4j.servletlearn.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties db = PropsUtil.loadProps("db.properties");
        DRIVER = db.getProperty("jdbc.driver");
        URL = db.getProperty("jdbc.url");
        USERNAME = db.getProperty("jdbc.username");
        PASSWORD = db.getProperty("jdbc.password");

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver",e);
        }
    }

    /**
     * 获取客户列表
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        Connection conn = null;
        try {
            List<Customer> customerList = new ArrayList<>();
            String sql = "select * from customer";
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet res = statement.executeQuery();
            while (res.next()){
                Customer customer = new Customer();
                customer.setPid(res.getString("id"));
                customer.setContact(res.getString("contact"));
                customer.setEmail(res.getString("email"));
                customer.setName(res.getString("name"));
                customer.setRemark(res.getString("remark"));
                customer.setTelephone(res.getString("telephone"));
                customerList.add(customer);
            }
            return customerList;
        }catch (SQLException e) {
            LOGGER.error("execute sql failure",e);
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("close connection failure",e);
                }
            }
        }
        return null;
    }

    public Customer getCustomer(String pid) {
        return null;
    }

    public boolean createCustomer(Map<String,Object> fieldMap) {
        return false;
    }

    public boolean updateCustomer(String pid,Map<String,Object> fieldMap) {
        return false;
    }

    public boolean deleteCustomer(String pid) {
        return false;
    }
}
