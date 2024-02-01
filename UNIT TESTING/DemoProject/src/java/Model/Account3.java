/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Account3 {
    String acname, pass, per, fname, lname, email, phone, address;

    public Account3 () {
        connect();
    }

    public Account3 (String acname, String pass, String per, String fname, String lname, String email,String phone, String address) {
        this.acname = acname;
        this.pass = pass;
        this.per = per;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        connect();

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAcname() {
        return acname;
    }

    public void setAcname(String acname) {
        this.acname = acname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    Connection cnn;//kết nối DB
    Statement stm;//Thực thi câu lệnh
    PreparedStatement pstm;//Thuc thi SQL
    ResultSet rs;//Lưu trữ và sử lý dữ liệu

    private void connect() {
        try {
            cnn = (new DBContext().connection);
            if (cnn != null) {
                System.out.println("Connect successfully");
            } else {
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {

        }
    }

   

    public void add(String acnamee, String passs, String per, String fnamee, String lnamee, String emaill, String phonee, String addresss) {
        try {
            String strAdd = "insert into Account (AccountName,Pass,Permission,Firtname,Lastname,email,NumberPhone,addres) values (?,HASHBYTES('SHA2_256',?),?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, acnamee);
            pstm.setString(2, passs);
            pstm.setString(3, per);
            pstm.setString(4, fnamee);
            pstm.setString(5, lnamee);
            pstm.setString(6, emaill);
            pstm.setString(7, phonee);
            pstm.setString(8, addresss);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("add:" + e.getMessage());
            
        }
    }

    

    
   

    public static void main(String[] args) {
        Account3 a = new Account3();
        String username = "username";
//        ArrayList<Account> data = a.listAccount(username);
//        for(Account o: data){
//            System.out.println(o);
//        }
//        a.add("hungtrinh","123123","1","hung","trinh","trinhhuuhung123@gmail.com","09999","thanh xuan");
    }
    public Account3 listAccount(String username) {
        try {
            String strSelect = "select * from Account "
                    + "where [AccountName] = ? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String acname = rs.getString(1);
                String pass = rs.getString(2);
                String per = rs.getString(3);
                String fname = rs.getString(4);
                String lname = rs.getString(5);
                String email = rs.getString(6);
                String phone = rs.getString(7);
                String address = rs.getString(8);
                return new Account3(acname, pass, per, fname, lname, email, phone, address);

            }
        } catch (Exception e) {
            System.out.println("listAccount:" + e.getMessage());
        }
        return null;
    }
//    public static final String PASSWORD_PATTERN = "((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{8,50})"; 
//    public static final String PASSWORD_PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
}
