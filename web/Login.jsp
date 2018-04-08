<%-- 
    Document   : Login
    Created on : Apr 5, 2018, 11:38:25 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Login</title>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans|Prompt" rel="stylesheet">

        <!--Style-->
        <link href="css/loginStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="css/animate.css" />
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Script tags-->
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>





    </head>
    <body>
        <div class="bg">
            <div class="slideInDown animated">
                <center><img src="image/logoWithTitle.png" class="logo"></center>
            </div>

            <section id="login">
                <div class="container flipInY animated">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-wrap">

                                <form role="form" action="ServletLogin" method="post" id="login-form" autocomplete="off">

                                    <div class="form-group">
                                        <label  class="sr-only">Username</label>
                                        <input type="text" name="username" id="username" class="form-control" placeholder="Username">
                                    </div>

                                    <div class="form-group">
                                        <label for="key" class="sr-only">Password</label>
                                        <input type="password" name="userpass" id="key" class="form-control" placeholder="Password">
                                    </div>

                                    <div class="checkbox">
                                        <span class="character-checkbox" onclick="showPassword()"></span>
                                        <span class="label">Show password</span>
                                    </div>

                                    <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Log in">
                              
                                </form>


                            </div>
                        </div> <!-- /.col-xs-12 -->
                    </div> <!-- /.row -->
                </div> <!-- /.container -->
            </section>

        </div>



        <script type="text/javascript">
            function showPassword() {

                var key_attr = $('#key').attr('type');

                if (key_attr != 'text') {

                    $('.checkbox').addClass('show');
                    $('#key').attr('type', 'text');

                } else {

                    $('.checkbox').removeClass('show');
                    $('#key').attr('type', 'password');

                }

            }
        </script>
    </body>
</html>
