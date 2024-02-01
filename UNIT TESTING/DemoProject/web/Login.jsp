<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <title>Login 05</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/accountcreate.css">


    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v17.0&appId=YOUR_APP_ID&autoLogAppEvents=1"></script>

        <script>
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '793594985493909',
                    xfbml: true,
                    version: 'v17.0'
                });
                FB.AppEvents.logPageView();
            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {
                    return;
                }
                js = d.createElement(s);
                js.id = id;
                js.src = "https://connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-5">
                        <div class="wrap">
                            <div class="img" style="background-image: url(https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn//News/1499962//laptop-20-800x450-2.jpg);"></div>
                            <div class="login-wrap p-4 p-md-5">
                                <div class="d-flex">
                                    <div class="w-100">
                                        <h3 class="mb-4">Sign In</h3>
                                    </div>
                                    <script>
                                        function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
                                            console.log('statusChangeCallback');
                                            console.log(response);                   // The current login status of the person.
                                            if (response.status === 'connected') {   // Logged into your webpage and Facebook.
                                                testAPI();
                                            } else {                                 // Not logged into your webpage or we are unable to tell.
                                                document.getElementById('status').innerHTML = '' +
                                                        '';
                                            }
                                        }


                                        function checkLoginState() {               // Called when a person is finished with the Login Button.
                                            FB.getLoginStatus(function (response) {   // See the onlogin handler
                                                statusChangeCallback(response);
                                            });
                                        }


                                        window.fbAsyncInit = function () {
                                            FB.init({
                                                appId: '793594985493909',
                                                cookie: true, // Enable cookies to allow the server to access the session.
                                                xfbml: true, // Parse social plugins on this webpage.
                                                version: 'v17.0'           // Use this Graph API version for this call.
                                            });


                                            FB.getLoginStatus(function (response) {   // Called after the JS SDK has been initialized.
                                                statusChangeCallback(response);        // Returns the login status.
                                            });
                                        };

                                        function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
                                            console.log('Welcome!  Fetching your information.... ');
                                            FB.api('/me', function (response) {
                                                console.log('Successful login for: ' + response.name);
                                                document.getElementById('status').innerHTML =
                                                        'Thanks for logging in, ' + response.name + '!';
                                            });
                                        }

                                    </script>


                                    <!-- The JS SDK Login Button -->

                                    <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                    </fb:login-button>

                                    <div id="status">
                                    </div>

                                </div>
                                <form action="login" class="signin-form" method="post">
                                    <div class="form-group mt-3"> 
                                        <input type="text" class="form-control" required name="acname">
                                        <label class="form-control-placeholder" for="username">Username</label>
                                    </div>
                                    <div class="form-group">
                                        <input id="password-field" type="password" class="form-control" required name="pass">
                                        <label class="form-control-placeholder" for="password">Password</label>
                                        <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
                                    </div>
                                    <div class="form-group d-md-flex">
                                        <div class="w-50 text-left">
                                            <label class="checkbox-wrap checkbox-primary mb-0">Remember Me
                                                <input type="checkbox" checked>
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <div class="w-50 text-md-right">
                                            <a href="Email.jsp">Forgot Password</a>
                                        </div>
                                    </div>
                                </form>
                                <p class="text-center">Not a member? <a href="Register.jsp">Sign Up</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

