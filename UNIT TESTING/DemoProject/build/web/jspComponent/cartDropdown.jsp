<%-- 
    Document   : cartDropdown
    Created on : Jun 7, 2023, 10:04:38 AM
    Author     : Dinh Nguyen
--%>

<div class="cart-dropdown">
    <% if (carts != null && !carts.isEmpty()) { %>
    <div class="cart-list">
        <!-- Cart Items -->
        <% for (Cart c : carts) { %>
        <div class="product-widget">
            <div class="product-img">
                <img src="<%= c.getImg() %>" alt="">
            </div>
            <div class="product-body">
                <h3 class="product-name"><a href="#"><%= c.getpName() %></a></h3>
                <h4 class="product-price"><span class="qty"><%= c.getQuantity() %>x</span><fmt:formatNumber type="currency" value="<%= c.getPrice() %>" currencyCode="VND" maxFractionDigits="0" /></h4>
            </div>
            <a href="home?seri=<%= c.getSeri() %>&del=1"><button name="del" class="delete"><i class="fa fa-close"></i></button></a>
        </div>
        <% } %>
        <!-- Cart Items -->
    </div>
    <% } else { %>
    <div class="empty-cart-notification">
        Your cart is empty!
    </div>
    <% } %>
    <div class="cart-summary">
        <small><%= carts.size() %> Item(s) selected</small>
        <% float total = 0;
            for (Cart c : carts) { 
                total += c.getQuantity() * c.getPrice();
            }
        %>
        <h5>SUBTOTAL: <fmt:formatNumber type="currency" value="<%= total %>" currencyCode="VND" maxFractionDigits="0" /></h5>
    </div>
    <div class="cart-btns">
        <a href="cart?btnViewCart=1">View Cart</a>
        <a href="#">Checkout <i class="fa fa-arrow-circle-right"></i></a>
    </div>
</div>
