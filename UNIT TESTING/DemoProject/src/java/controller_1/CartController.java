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
 * @author Dinh Nguyen
 */
@WebServlet(name = "CartController ", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cart at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderDAO orderDao = new OrderDAO();
        OrderDetailDAO odDao = new OrderDetailDAO();
        List<Cart> carts = (List<Cart>) session.getAttribute("Cart");
        
        if (request.getParameter("del") != null) {
            String seri = request.getParameter("seri");
            List<Cart> itemsToRemove = new ArrayList<>();
            for (Cart c : carts) {
                if (c.getSeri().equals(seri)) {
                    itemsToRemove.add(c);
                }
            }
            carts.removeAll(itemsToRemove);
            session.setAttribute("Cart", carts);
            response.sendRedirect("home");
        }
        
        if (request.getParameter("delCart") != null) {
            String seri = request.getParameter("seri");
            List<Cart> itemsToRemove = new ArrayList<>();
            for (Cart c : carts) {
                if (c.getSeri().equals(seri)) {
                    itemsToRemove.add(c);
                }
            }
            carts.removeAll(itemsToRemove);
            session.setAttribute("Cart", carts);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        }
        
        if (request.getParameter("btnViewCart") != null) {
            if (session.getAttribute("acc") != null) {
                response.sendRedirect("Cart.jsp");
            }
            else {
                response.sendRedirect("Login.jsp");
            }
        }
//        
        if (request.getParameter("update") != null) {
            String seri = request.getParameter("seri");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float price = Float.parseFloat(request.getParameter("price"));
            for (Cart c : carts) {
                if (c.getSeri().equals(seri)) {
                    c.setQuantity(quantity);
                }
            }
            float totalPrice = price * quantity;
            session.setAttribute("Cart", carts);
            session.setAttribute("totalPrice", totalPrice);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
//            response.sendRedirect("Cart.jsp");
        }

        if (request.getParameter("btnDelAll") != null) {
            session.setAttribute("Cart", null);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        }

//        if (request.getParameter("btnCheckOut") != null) {
//            int aid = Integer.parseInt(request.getParameter("aid"));
//            List<Cart> carts = (List<Cart>) session.getAttribute("Cart");
//            orderDao.addOrder(aid, carts);
//            odDao.addOrderDetail(carts);
//            cartDao.DelCartByAccountId(aid);
//            session.setAttribute("Cart", null);
//            response.sendRedirect("home");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDAO pDao = new ProductDAO();
        ProductTypeDAO ptDao = new ProductTypeDAO();
        List<Cart> carts = (List<Cart>) session.getAttribute("Cart");
        String referer = request.getHeader("referer");

        //btn add to cart click
        if (request.getParameter("addToCart") != null) {
            boolean isUpdateCart = false;
            if (session.getAttribute("acc") != null) {
                String seri = request.getParameter("seri");
                Product p = pDao.getProductBySeri(seri);
                String pName = ptDao.getProductNameByPid(p.getPid());
                if (carts == null) {
                    carts = new ArrayList<>();
                    carts.add(new Cart(seri, pName, p.getImg(), 1, p.getPrice()));
                } else {
                    //check if product exist in Cart
                    for (Cart c : carts) {
                        if (c.getSeri().equals(seri) && !isUpdateCart) {
                            isUpdateCart = true;
                            int newQty = c.getQuantity() + 1;
                            c.setQuantity(newQty);
                        }
                    }
                    //if not add a new cart item
                    if (!isUpdateCart) {
                        carts.add(new Cart(seri, pName, p.getImg(), 1, p.getPrice()));
                    }
                }
                session.setAttribute("Cart", carts);

                if (referer != null && !referer.isEmpty()) {
                    response.sendRedirect(referer);
                } else {
                    // If no referer is available, redirect to a default page
                    response.sendRedirect("home");
                }
            } else {
                response.sendRedirect("Login.jsp");
            }
        }
    }
    
    
    
}
