<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Book---Issue!</title>
   <style type="text/css">
a{
   
   breadth:50px;
   length:150px;
}

body{
  background-color:violet;
}
h1{
    margin-top:30px;
   text-align:center;
   color:white;
}
</style>  
  </head>
  <body>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <div>
        <a href="index.jsp"><button type="button" class="btn btn-secondary btn-lg" style="margin-right:50px">HOME</button></a>
       
    <h1 style="color:white">Welcome in Library House!</h1>
   <h1>This Section Is Only For Librarian </h1>
        
        <div class="container" style="margin-top:100px;" >
  <div class="row">
    <div class="col"><a href="add_member.jsp"><button   type="button" id="button" class="btn btn-primary btn-lg">ADD--MEMBER</button></a></div>
    <div class="col"> <a href="delete_member.jsp"> <button type="button" id="button" class="btn btn-dark btn-lg">DELETE-MEMBER</button></a></div>
    <div class="col"></div>
    <div class="col"> <a href="add_book.jsp"><button   type="button" id="button" class="btn btn-primary btn-lg">ADD--BOOK</button></a></div>
    <div class="col"><a href="delete_book.jsp"><button type="button" id="button" class="btn btn-dark btn-lg">DELETE-BOOK</button></a></div>
  </div>
</div>
         
    </div>
    </body>
    </html>