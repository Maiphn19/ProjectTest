/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Context.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dinh Nguyen
 */
public class OrderDAO extends MyDAO{

    public OrderDAO() {
        super();
    }
    
    
    public boolean addOrder(int aid, List<Cart> carts){
        double total = 0;
        for(Cart c : carts){
            total += c.getPrice()*c.getQuantity();
        }
        String sql = "insert into [Order](AccountID, OrderDate, total) values (?,?,?)";
        Date date = new Date(); 
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setDouble(3, total);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("addOrderDetail"+e.getMessage());
        }
        return false;
    }
    
    public boolean addOrder(int aid, Cart c){
        String sql = "insert into [Order](AccountID, OrderDate, total) values (?,?,?)";
        Date date = new Date(); 
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setDouble(3, c.getQuantity()*c.getPrice());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("addOrderDetail"+e.getMessage());
        }
        return false;
    }
    
    public int getNewestOrderId(){
        String sql = "select top 1 * from [Order] order by OrderID desc";
        int id = 1;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("getNewestOrderID Error"+e.getMessage());
        }
        return id;
    }
    
}
