/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Context.*;
import Model.ProductDisplay;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinh Nguyen
 */
public class ProductDisplayDAO extends MyDAO {
    
    public List<ProductDisplay> getProductByCate(int sid) {
        xSql = "Select p.Seri, pt.productName, s.supplierName, p.images, p.price from Product p JOIN ProductType pt ON p.ProductID = pt.productID JOIN Supplier s ON s.supplierID = pt.supplierID where s.supplierID =?";
        List<ProductDisplay> t = new ArrayList<>();
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            String seri, pname, sname, img;
            float price;
            ProductDisplay x;
            while (rs.next()) {
                seri = rs.getString(1);
                pname = rs.getString(2);
                sname = rs.getString(3);
                img = rs.getString(4);
                price = rs.getFloat(5);
                x = new ProductDisplay(seri, pname, sname, img, price);
                t.add(x);
            }
        } catch (Exception e) {
            System.err.println("readCartDetail"+e.getMessage());
        }
        return (t);
    }

    public List<ProductDisplay> getNewestProductByCate(int sid) {
        xSql = "Select top 10 p.Seri, pt.productName, s.supplierName, p.images, p.price from Product p JOIN ProductType pt ON p.ProductID = pt.productID JOIN Supplier s ON s.supplierID = pt.supplierID where s.supplierID =?";
        List<ProductDisplay> t = new ArrayList<>();
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            String seri, pname, sname, img;
            float price;
            ProductDisplay x;
            while (rs.next()) {
                seri = rs.getString(1);
                pname = rs.getString(2);
                sname = rs.getString(3);
                img = rs.getString(4);
                price = rs.getFloat(5);
                x = new ProductDisplay(seri, pname, sname, img, price);
                t.add(x);
            }
        } catch (Exception e) {
            System.err.println("readCartDetail"+e.getMessage());
        }
        return (t);
    }
    
    public List<ProductDisplay> getTopSelling() {
        xSql = "Select top 10 p.Seri, pt.productName, s.supplierName, p.images, p.price from Product p JOIN ProductType pt ON p.ProductID = pt.productID JOIN Supplier s ON s.supplierID = pt.supplierID ORDER BY sell desc";
        List<ProductDisplay> t = new ArrayList<>();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String seri, pname, sname, img;
            float price;
            ProductDisplay x;
            while (rs.next()) {
                seri = rs.getString(1);
                pname = rs.getString(2);
                sname = rs.getString(3);
                img = rs.getString(4);
                price = rs.getFloat(5);
                x = new ProductDisplay(seri, pname, sname, img, price);
                t.add(x);
            }
        } catch (Exception e) {
            System.err.println("readCartDetail"+e.getMessage());
        }
        return (t);
    }
    
    public List<ProductDisplay> getAllProductDisplay() {
        xSql = "Select p.Seri, pt.productName, s.supplierName, p.images, p.price from Product p JOIN ProductType pt ON p.ProductID = pt.productID JOIN Supplier s ON s.supplierID = pt.supplierID";
        List<ProductDisplay> t = new ArrayList<>();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String seri, pname, sname, img;
            float price;
            ProductDisplay x;
            while (rs.next()) {
                seri = rs.getString(1);
                pname = rs.getString(2);
                sname = rs.getString(3);
                img = rs.getString(4);
                price = rs.getFloat(5);
                x = new ProductDisplay(seri, pname, sname, img, price);
                t.add(x);
            }
        } catch (Exception e) {
            System.err.println("readCartDetail"+e.getMessage());
        }
        return (t);
    }
    
}
