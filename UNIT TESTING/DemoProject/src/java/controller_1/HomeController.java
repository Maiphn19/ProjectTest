/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_1;

import Model.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khang
 */
@WebServlet(name = "HomeController ", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SupplierDAO supDao = new SupplierDAO();
        ProductDisplayDAO pdDao = new ProductDisplayDAO();
        Pagination Page = new Pagination();

        //Get Lists
        List<Supplier> supList = supDao.getAllSupplier();
        int idSupSelect = 1;
        List<ProductDisplay> product;
        List<ProductDisplay> topSell = pdDao.getTopSelling();
        List<Cart> carts = (List<Cart>) session.getAttribute("Cart");

        //Select Supplier
        if (request.getParameter("supSelect") != null) {
            idSupSelect = Integer.parseInt(request.getParameter("supSelect"));
        }
        //Get products
        product = pdDao.getNewestProductByCate(idSupSelect);
        request.setAttribute("ss", idSupSelect);

        //setting cart
//        if (session.getAttribute("acc") != null) {
//            Account acc = (Account) session.getAttribute("acc");
//            if (cartDao.getCartByAccount(acc.getAcId()) != null) {
//                List<Cart> carts = cartDao.getCartByAccount(acc.getAcId());
//                session.setAttribute("Cart", carts);
//            }
//        }
        //Set attribute
        session.setAttribute("supList", supList);
        request.setAttribute("ss", idSupSelect);
        session.setAttribute("product", product);
        session.setAttribute("topSell", topSell);

        //Home Cart
        if (request.getParameter("del") != null) {
            String seri = request.getParameter("seri");
            List<Cart> itemsToRemove = new ArrayList<>();
            int count = 0;
            for (Cart c : carts) {
                if (c.getSeri().equals(seri)) {
                    itemsToRemove.add(c);
                }
                count++;
            }
            carts.removeAll(itemsToRemove);
            session.setAttribute("Cart", carts);
        }

        //redirect
//        if ((Account) session.getAttribute("acct") != null) {
//            Account acct = (Account) session.getAttribute("acct");
//            if (acct.getPer() != "customer") {
//                request.getRequestDispatcher("ProductManager.jsp").forward(request, response);
//            } else {
        request.getRequestDispatcher("Home.jsp").forward(request, response);
//            }
//        } else {
//            request.getRequestDispatcher("Home.jsp").forward(request, response);
//        }
    }

}
