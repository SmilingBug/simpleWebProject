package com.yang4j.servletlearn.test;

import com.yang4j.servletlearn.helper.DatabaseHelper;
import com.yang4j.servletlearn.model.Customer;
import com.yang4j.servletlearn.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init() {
        //初始化数据库
        String file = "sql/customer_init.sql";
        DatabaseHelper.executeSqlFile(file);
    }

    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = customerService.getCustomerList("");
        Assert.assertEquals(11,customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{
        String pid = "1";
        Customer customer = customerService.getCustomer(pid);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("name","yang");
        fieldMap.put("contact","qian");
        fieldMap.put("telephone","14563828783");
        boolean res = customerService.createCustomer(fieldMap);
        Assert.assertTrue(res);
    }

    @Test
    public void updateCustomerTest() throws Exception{
        String pid = "2";
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("contact","Eric");
        boolean res = customerService.updateCustomer(pid,fieldMap);
        Assert.assertTrue(res);
    }

    @Test
    public void deleteCustomerTest() throws Exception{
        String pid = "3";
        boolean res = customerService.deleteCustomer(pid);
        Assert.assertTrue(res);
    }

    @Test
    public void getUUIDTest() {
        System.out.print(UUID.randomUUID().toString().replace("-",""));
    }
}
