/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_1;

import Model.Cart;
import Model.Pagination;
import Model.ProductDisplay;
import Model.ProductDisplayDAO;
import Model.Supplier;
import Model.SupplierDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author khang
 */
public class ShopController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SupplierDAO supDao = new SupplierDAO();
        ProductDisplayDAO pdDao = new ProductDisplayDAO();
        Pagination Page;
        
        //Get Lists
        List<Supplier> supList = supDao.getAllSupplier();
        List<ProductDisplay> product = pdDao.getAllProductDisplay();
        List<ProductDisplay> topSell = pdDao.getTopSelling();
        List<Cart> carts = (List<Cart>) session.getAttribute("Cart");
        
        //seting pagination
        if (session.getAttribute("page") == null) {
            Page = new Pagination(product.size(), 9, 1);
            session.setAttribute("page", Page);
        } else if (request.getParameter("cp") != null) {
            int cp = Integer.parseInt(request.getParameter("cp"));
            Page = new Pagination(product.size(), 9, cp);
            session.setAttribute("page", Page);
        }
        
        //Set attribute
        session.setAttribute("supList", supList);
        session.setAttribute("product", product);
        session.setAttribute("topSell", topSell);
        
        request.getRequestDispatcher("Shop.jsp").forward(request, response);
    }
    
    
}
