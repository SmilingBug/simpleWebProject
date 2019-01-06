package com.yang4j.servletlearn.service;

import com.yang4j.servletlearn.helper.DatabaseHelper;
import com.yang4j.servletlearn.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomer(String pid) {
        String sql = "select * from customer where id = '"+pid+"'";
        return DatabaseHelper.queryEntity(Customer.class,sql);
    }

    public boolean createCustomer(Map<String,Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }

    public boolean updateCustomer(String pid,Map<String,Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class,pid,fieldMap);
    }

    public boolean deleteCustomer(String pid) {
        return DatabaseHelper.deleteEntity(Customer.class,pid);
    }
}
