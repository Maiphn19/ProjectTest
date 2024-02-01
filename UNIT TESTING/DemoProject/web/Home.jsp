<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Context.*" %>
<%@page import = "Model.*" %>
<%@page import= "java.util.*" %>
<html>
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

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <%
        SupplierDAO supDao = new SupplierDAO();
        List<Supplier> supList = supDao.getAllSupplier();
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
                                    <!-- cart dropdown -->
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
                <!-- row -->
                <div class="row">
                    <!-- shop -->
                    <div class="col-md-4 col-xs-6">
                        <div class="shop">
                            <div class="shop-img">
                                <img src="./img/shop01.png" alt="">
                            </div>
                            <div class="shop-body">
                                <h3>Laptop<br>Collection</h3>
                                <a href="shop" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    <!-- /shop -->

                    <!-- shop -->
                    <div class="col-md-4 col-xs-6">
                        <div class="shop">
                            <div class="shop-img">
                                <img src="./img/shop03.png" alt="">
                            </div>
                            <div class="shop-body">
                                <h3>Accessories<br>Collection</h3>
                                <a href="shop" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    <!-- /shop -->

                    <!--                     shop 
                                        <div class="col-md-4 col-xs-6">
                                            <div class="shop">
                                                <div class="shop-img">
                                                    <img src="./img/shop02.png" alt="">
                                                </div>
                                                <div class="shop-body">
                                                       <h3>Cameras<br>Collection</h3>
                                                    <a href="shop" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                         /shop -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                   <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <h3 class="title">New Products</h3>
                                <div name="supSelect" class="section-nav">
                                    <ul class="section-tab-nav tab-nav">
                                        <%
                                            for (Supplier sup : supList) {
                                                int ss = 1;
                                                Object ssObj = request.getAttribute("ss");
                                                if (ssObj != null) {
                                                    ss = (int) ssObj;
                                                }
                                        %>
                                            <li <% if (ss==sup.getSid()) { %>class="active"<% } %>>
                                                <a data-toggle="tab" href="" onclick="redirectToHomeController('<%= sup.getSid() %>')"><%= sup.getSname() %></a>
                                            </li>
                                        <% 
                                            }
                                        %>
                                    </ul>
                                </div>
                        </div>
                    </div>
                    <script>
                        function redirectToHomeController(supSelect) {
                            var url = "home?supSelect=" + supSelect;
                            window.location.href = url;
                        }
                    </script>
                    <!-- /section title -->

                   <!-- Products tab & slick -->
                    <div class="col-md-12">
                        <div class="row">
                            <div class="products-tabs">
                                <!-- tab -->
                                <div id="tab1" class="tab-pane active">
                                    <div class="products-slick" data-nav="#slick-nav-1">
                                        <c:forEach items="${sessionScope.product}" var="p">
                                        <!-- product -->
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="${p.getImg()}" alt="">
<!--                                                <div class="product-label">
                                                    <span class="sale">-30%</span>
                                                    <span class="new">NEW</span>
                                                </div>-->
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${p.getSname()}</p>
                                                <h3 class="product-name"><a href="#">${p.getPname()}</a></h3>
                                                <h4 class="product-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" />
                                                    <del class="product-old-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" /></del></h4>
                                                <div class="product-rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                </div>
                                            </div>
                                            <form action="cart" method="post">
                                                <div class="add-to-cart">
                                                    <button name="addToCart" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                    <input hidden name="seri" value="${p.getSeri()}">
                                                </div>
                                            </form>
                                        </div>
                                        <!-- /product -->
                                        </c:forEach>
                                    </div>
                                    <div id="slick-nav-1" class="products-slick-nav"></div>
                                </div>
                                <!-- /tab -->
                            </div>
                        </div>
                    </div>
                    <!-- Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- HOT DEAL SECTION -->
        <div id="hot-deal" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="hot-deal">
                            <ul class="hot-deal-countdown">
                                <li>
                                    <div>
                                        <h3>02</h3>
                                        <span>Days</span>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <h3>10</h3>
                                        <span>Hours</span>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <h3>34</h3>
                                        <span>Mins</span>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <h3>60</h3>
                                        <span>Secs</span>
                                    </div>
                                </li>
                            </ul>
                            <h2 class="text-uppercase">hot deal this week</h2>
                            <p>New Collection Up to 50% OFF</p>
                            <a class="primary-btn cta-btn" href="#">Shop now</a>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /HOT DEAL SECTION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <h3 class="title">Top selling</h3>
                        </div>
                    </div>
                    <!-- /section title -->

                    <!-- Products tab & slick -->
                    <div class="col-md-12">
                        <div class="row">
                            <div class="products-tabs">
                                <!-- tab -->
                                <div id="tab2" class="tab-pane active">
                                    <div class="products-slick" data-nav="#slick-nav-2">
                                        <c:forEach items="${sessionScope.topSell}" var="p">
                                        <!-- product -->
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="${p.getImg()}" alt="">
<!--                                                <div class="product-label">
                                                    <span class="sale">-30%</span>
                                                    <span class="new">NEW</span>
                                                </div>-->
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${p.getSname()}</p>
                                                <h3 class="product-name"><a href="#">${p.getPname()}</a></h3>
                                                <h4 class="product-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" />
                                                    <del class="product-old-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" /></del></h4>
                                                <div class="product-rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                </div>
                                            </div>
                                            <form action="cart" method="post">
                                                <div class="add-to-cart">
                                                    <button name="addToCart" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                    <input hidden name="seri" value="${p.getSeri()}">
                                                </div>
                                            </form>
                                        </div>
                                        <!-- /product -->
                                        </c:forEach>
                                    </div>
                                    <div id="slick-nav-2" class="products-slick-nav"></div>
                                </div>
                                <!-- /tab -->
                            </div>
                        </div>
                    </div>
                    <!-- /Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-4 col-xs-6">
                        <div class="section-title">
                            <h4 class="title">Top selling</h4>
                            <div class="section-nav">
                                <div id="slick-nav-3" class="products-slick-nav"></div>
                            </div>
                        </div>

                        <div class="products-widget-slick" data-nav="#slick-nav-3">
                            <c:forEach items="${sessionScope.topSell}" var="p" varStatus="status">
                                <!-- Check if a new column should start -->
                                <c:if test="${status.index % 3 == 0}">
                                    <div>
                                </c:if>

                                <!-- product widget -->
                                <div class="product-widget">
                                    <div class="product-img">
                                        <img src="${p.getImg()}" alt="">
                                    </div>
                                    <div class="product-body">
                                        <p class="product-category">${p.getSname()}</p>
                                        <h3 class="product-name"><a href="#">${p.getPname()}</a></h3>
                                        <h4 class="product-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" />
                                            <del class="product-old-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" /></del>
                                        </h4>
                                    </div>
                                </div>
                                <!-- /product widget -->

                                <!-- Check if a column should end -->
                                <c:if test="${status.index % 3 == 2 or status.last}">
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="col-md-4 col-xs-6">
                        <div class="section-title">
                            <h4 class="title">Top selling</h4>
                            <div class="section-nav">
                                <div id="slick-nav-4" class="products-slick-nav"></div>
                            </div>
                        </div>

                        <div class="products-widget-slick" data-nav="#slick-nav-4">
                            <c:forEach items="${sessionScope.topSell}" var="p" varStatus="status">
                                <!-- Check if a new column should start -->
                                <c:if test="${status.index % 3 == 0}">
                                    <div>
                                </c:if>

                                <!-- product widget -->
                                <div class="product-widget">
                                    <div class="product-img">
                                        <img src="${p.getImg()}" alt="">
                                    </div>
                                    <div class="product-body">
                                        <p class="product-category">${p.getSname()}</p>
                                        <h3 class="product-name"><a href="#">${p.getPname()}</a></h3>
                                        <h4 class="product-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" />
                                            <del class="product-old-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" /></del>
                                        </h4>
                                    </div>
                                </div>
                                <!-- /product widget -->

                                <!-- Check if a column should end -->
                                <c:if test="${status.index % 3 == 2 or status.last}">
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="clearfix visible-sm visible-xs"></div>

                    <div class="col-md-4 col-xs-6">
                        <div class="section-title">
                            <h4 class="title">Top selling</h4>
                            <div class="section-nav">
                                <div id="slick-nav-5" class="products-slick-nav"></div>
                            </div>
                        </div>

                        <div class="products-widget-slick" data-nav="#slick-nav-5">
                            <c:forEach items="${sessionScope.topSell}" var="p" varStatus="status">
                                <!-- Check if a new column should start -->
                                <c:if test="${status.index % 3 == 0}">
                                    <div>
                                </c:if>

                                <!-- product widget -->
                                <div class="product-widget">
                                    <div class="product-img">
                                        <img src="${p.getImg()}" alt="">
                                    </div>
                                    <div class="product-body">
                                        <p class="product-category">${p.getSname()}</p>
                                        <h3 class="product-name"><a href="#">${p.getPname()}</a></h3>
                                        <h4 class="product-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" />
                                            <del class="product-old-price"><fmt:formatNumber type="currency" value="${p.getPrice()}" currencyCode="VND" maxFractionDigits="0" /></del>
                                        </h4>
                                    </div>
                                </div>
                                <!-- /product widget -->

                                <!-- Check if a column should end -->
                                <c:if test="${status.index % 3 == 2 or status.last}">
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>

                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- NEWSLETTER -->
        <%@include file="jspComponent/newsletter.jsp" %>
        <!-- /NEWSLETTER -->

        <!-- FOOTER -->
        <%@include file="jspComponent/footer.jsp" %>
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
