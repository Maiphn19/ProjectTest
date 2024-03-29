<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Context.*" %>
<%@page import = "Model.*" %>
<%@page import= "java.util.*" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Electro - HTML Ecommerce Template</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <link href="css/style1.css" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <%
        List<Cart> carts = new ArrayList<>();
        if (session.getAttribute("Cart") != null) {
            carts = (List<Cart>) session.getAttribute("Cart");
        }
    %>
    <body>
        <!-- HEADER -->
        <header>
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-left">
                        <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <c:if test="${sessionScope.acc != null}">
                            <li><a href="logout"><i class="fa fa-user-o"></i> Logout</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                            <li><a href="Login.jsp"><i class="fa fa-user-o"></i> Login</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acct != null}">
                            <li><a href="manager"><i class="fa fa-user-o"></i> Manager</a></li>
                            </c:if>   
                        <li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
                    </ul>
                </div>
            </div>
            <!-- /TOP HEADER -->

            <!-- MAIN HEADER -->
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="#" class="logo">
                                    <img src="./img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
                        <div class="col-md-6">
                            <div class="header-search">
                                <form>
                                    <select class="input-select">
                                        <option value="0">All Categories</option>
                                        <option value="1">Category 01</option>
                                        <option value="1">Category 02</option>
                                    </select>
                                    <input class="input" id="search" placeholder="Search here">
                                    <button class="search-btn">Search</button>
                                    <ul id="searchResults" class=""></ul>
                                </form>
                            </div>
                            <script>
                                document.getElementById('search').addEventListener('input', function (event) {
                                    var keyword = event.target.value.toLowerCase();
                                    var searchResults = document.getElementById('searchResults');

                                    // Clear previous search results
                                    while (searchResults.firstChild) {
                                        searchResults.removeChild(searchResults.firstChild);
                                    }

                                    // Check if the entered keyword is not empty
                                    if (keyword.length > 0) {
                                        // Send an Ajax request to search in the database
                                        var xhr = new XMLHttpRequest();
                                        xhr.open('GET', 'search?keyword=' + keyword, true);
                                        xhr.onreadystatechange = function () {
                                            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                                                var products = JSON.parse(xhr.responseText);

                                                // Display the search results
                                                for (var i = 0; i < products.length; i++) {
                                                    var li = document.createElement('li');
                                                    var productLink = document.createElement('a');
                                                    productLink.href = 'searchsmart?pid=' + products[i].pid; // Set the link URL
                                                    var productName = products[i].pname;
                                                    productLink.innerHTML = highlightKeyword(productName, keyword);

                                                    // Add click event listener to the link
                                                    li.addEventListener('click', function (e) {
//                                            e.preventDefault(); // Prevent default link behavior
                                                        window.location.href = productLink.href; // Redirect to the link URL
                                                    });

                                                    li.appendChild(productLink);
                                                    searchResults.appendChild(li);
                                                }
                                            }
                                        };
                                        xhr.send();
                                    }
                                });

                                function highlightKeyword(text, keyword) {
                                    var regex = new RegExp('(' + keyword + ')', 'gi');
                                    return text.replace(regex, '<span style="color: red;">$1</span>');
                                }
                            </script>
                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <!-- Wishlist -->
                                <div>
                                    <a href="#">
                                        <i class="fa fa-heart-o"></i>
                                        <span>Your Wishlist</span>
                                        <div class="qty">2</div>
                                    </a>
                                </div>
                                <!-- /Wishlist -->
                                <!-- Cart -->
                                <div class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                        <i class="fa fa-shopping-cart"></i>
                                        <span>Your Cart</span>
                                        <% if (carts == null || carts.size()==0) { %>
                                        <div class="qty">0</div>
                                        <% } %>
                                        <% if (carts != null || carts.size()>0) { %>
                                        <div class="qty"><%= carts.size() %></div>
                                        <% } %>
                                    </a>
                                </div>
                                <!-- Cart -->
                                <!-- Menu Toogle -->
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                                <!-- /Menu Toogle -->
                            </div>
                        </div>
                        <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </div>
            <!-- /MAIN HEADER -->
        </header>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav -->
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Hot Deals</a></li>
                        <li><a href="#">Categories</a></li>
                        <li><a href="#">Laptops</a></li>
                        <li><a href="#">Smartphones</a></li>
                        <li><a href="#">Cameras</a></li>
                        <li><a href="#">Accessories</a></li>
                    </ul>
                    <!-- /NAV -->
                </div>
                <!-- /responsive-nav -->
            </div>
            <!-- /container -->
        </nav>
        <!-- /NAVIGATION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <% if (carts != null && carts.size()>0) { %>
                <div class="cart-view">
                    <table class="cart-view-table">
                        <tr>
                            <th></th>
                            <th>Image</th>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total Price</th>
                            <th>Action</th>
                        </tr>
                        <% 
                        float totalBill = 0;
                        int count = 0;
                        for (Cart c : carts) {
                            count++;
                        %>
                        <tr>
                            <td class="order"><%= count %></td>
                            <td class="product-image"><img src="<%= c.getImg() %>" alt="Product Image"></td>
                            <td class="product-name"><%= c.getpName() %></td>

                            <td class="quantity">
                                <div class="quantity">
                                    <input id="quantityInput<%= c.getSeri() %>" type="text" value="<%= c.getQuantity() %>" onchange="updateCart('<%= c.getSeri() %>', '<%= c.getPrice() %>')">
                                    <button class="decrement" onclick="decrementValue('<%= c.getSeri() %>', '<%= c.getPrice() %>')">-</button>
                                    <button class="increment" onclick="incrementValue('<%= c.getSeri() %>', '<%= c.getPrice() %>')">+</button>
                                </div>
                            </td>

                            <td class="price" id="price<%= c.getSeri() %>"><fmt:formatNumber type="currency" value="<%= c.getPrice() %>" currencyCode="VND" maxFractionDigits="0" /></td>

                            <td class="total-price" id="total<%= c.getSeri() %>"><fmt:formatNumber type="currency" value="<%= c.getQuantity() * c.getPrice() %>" currencyCode="VND" maxFractionDigits="0" /></td>
                            <td class="action"><a href="cart?seri=<%= c.getSeri() %>&delCart=1"><button>Delete</button></td>
                        </tr>
                        <%
                        }
                        %>
                    </table>
                    <div class="cart-view-table">
                        <% if (carts != null && carts.size() > 0) {
                            for (Cart c : carts) {
                                totalBill += c.getQuantity() * c.getPrice();
                            }
                        } %>
                        <div class="total-bill">Total Bill: <fmt:formatNumber type="currency" value="<%= totalBill %>" currencyCode="VND" maxFractionDigits="0" /></div>
                        <form method="get" action="cart">
                            <div class="button-container">
                                <button type="submit" name="btnDelAll" class="delete-all">Delete All</button>
                                <button class="checkout">Checkout</button>
                            </div>
                        </form>
                    </div>
                </div>
                <% } else { %>
                <div class="empty-cart-notification">
                    <p class="important">Your cart is empty!</p>
                    <a href="home" class="linkclick">Go Shopping</a>
                </div>
                <% } %>
            </div>
            <!-- container -->
        </div>
        <!-- SECTION -->

        <!-- NEWSLETTER -->
        <div id="newsletter" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="newsletter">
                            <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                            <form>
                                <input class="input" type="email" placeholder="Enter Your Email">
                                <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                            </form>
                            <ul class="newsletter-follow">
                                <li>
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /NEWSLETTER -->

        <!-- FOOTER -->
        <footer id="footer">
            <!-- top footer -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">About Us</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
                                <ul class="footer-links">
                                    <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                                    <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Categories</h3>
                                <ul class="footer-links">
                                    <li><a href="#">Hot deals</a></li>
                                    <li><a href="#">Laptops</a></li>
                                    <li><a href="#">Smartphones</a></li>
                                    <li><a href="#">Cameras</a></li>
                                    <li><a href="#">Accessories</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="clearfix visible-xs"></div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Information</h3>
                                <ul class="footer-links">
                                    <li><a href="#">About Us</a></li>
                                    <li><a href="#">Contact Us</a></li>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Orders and Returns</a></li>
                                    <li><a href="#">Terms & Conditions</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Service</h3>
                                <ul class="footer-links">
                                    <li><a href="#">My Account</a></li>
                                    <li><a href="#">View Cart</a></li>
                                    <li><a href="#">Wishlist</a></li>
                                    <li><a href="#">Track My Order</a></li>
                                    <li><a href="#">Help</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /top footer -->

            <!-- bottom footer -->
            <div id="bottom-footer" class="section">
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <ul class="footer-payments">
                                <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                                <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                                <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                            </ul>
                            <span class="copyright">
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </span>
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /bottom footer -->
        </footer>
        <!-- /FOOTER -->

        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/cart.js"></script>
    </body>
</html>

