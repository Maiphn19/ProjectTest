/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dinh Nguyen
 */
public class OrderDetail {

    int oid, accName, pid;
    String address, email, pName, quantity, price;

    public OrderDetail() {
    }

    public OrderDetail(int oid, int accName, int pid, String address, String email, String pName, String quantity, String price) {
        this.oid = oid;
        this.accName = accName;
        this.pid = pid;
        this.address = address;
        this.email = email;
        this.pName = pName;
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getAccName() {
        return accName;
    }
    
    public void setAccName(int accName) {
        this.accName = accName;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
    
}
