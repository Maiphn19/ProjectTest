/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Context.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinh Nguyen
 */
public class OrderDetailDAO extends MyDAO {

    public OrderDetailDAO() {
        super();
    }
    
    public boolean addOrderDetail(List<Cart> carts){
        String sql = "insert into OrderDetail(OrderID, productID, quantity, price)  values (?,?,?,?)";
        OrderDAO orderDao = new OrderDAO();
        for(Cart c : carts){
            try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderDao.getNewestOrderId());
            ps.setInt(2, c.getPid());
            ps.setInt(3, c.getQuantity());
            ps.setDouble(4, c.getPrice()*c.getQuantity());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("addOrderDetailerror"+e.getMessage());
            return false;
         }   
        }
        return true;
    }
    
    public boolean addOrderDetail(Cart c){
        String sql = "insert into OrderDetail(OrderID, productID, quantity, price)  values (?,?,?,?)";
        OrderDAO orderDao = new OrderDAO();
            try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderDao.getNewestOrderId());
            ps.setInt(2, c.getPid());
            ps.setInt(3, c.getQuantity());
            ps.setDouble(4, c.getPrice()*c.getQuantity());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("addOrderDetailerror"+e.getMessage());
            
         }  
            return false;
    }
        
}
