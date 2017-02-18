package com.iskill.service;
import com.iskill.helper.DatabaseHelper;
import com.iskill.model.Customer;
import com.iskill.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
public class CustomerService {
    /*private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;*/
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
  /*  static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver", e);
        }
    }*/
    public List<Customer> getCustomerList(){
       /* Connection conn = null;
        try {
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "SELECT * FROM customer";
//            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            conn = DatabaseHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        }catch (SQLException e){
            LOGGER.error("excute sql failure",e);
        }finally {
            DatabaseHelper.closeConnection(conn);
            if (conn!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    LOGGER.error("colse connection failure",e);
                }
            }
        }
        return null;
        */
        Connection conn = DatabaseHelper.getConnection();
        try {
            String sql = "SELECT * FROM customer";
            return DatabaseHelper.queryEntityList(Customer.class,sql);
        }finally {
            DatabaseHelper.closeConnection();
        }
    }
    //查询对象
    public Customer getCustomer(long id){
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntity(Customer.class,sql);
    }
    //创建对象
    public boolean createCustomer(Map<String,Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }
    //更新对象
    public boolean updateCustomer(long id,Map<String,Object>fieldMap){
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }
    //删除对象
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
