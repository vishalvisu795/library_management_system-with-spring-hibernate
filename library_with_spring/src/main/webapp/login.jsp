<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<!------ Include the above in your HEAD tag ---------->
<html>
<head>
<style type="text/css">
body {
  margin: 0;
  padding: 0;
  background-color: #17a2b8;
  height: 100vh;
   align-items: center;
}
#login .container #login-row #login-column #login-box {
  margin: 120px 280px;
  max-width: 600px;
  height: 320px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;  
   align-items: center;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
   align-items: center;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
   align-items: center;
}
</style>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">Enter Authentication KEY</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="login" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="text" name="password" class="form-control" required/>
                            </div>
                            <div>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>