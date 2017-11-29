<%-- 
    Document   : index
    Created on : 26-Nov-2017, 09:05:05
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width = device-width, user-scalable = no initial-scale = 1.0, maximum-scale = 1.0, minimum-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CasinoBender Home</title>
        <link rel="Stylesheet" href="css/bootstrap.min.css" >
        <link rel="Stylesheet" href="css/gui.css" >
        <script src="https://use.fontawesome.com/5ffb4732b9.js"></script>
    </head>
    
    <body>
        
        <jsp:include page="navigationBar.jsp" />
        
        <div class="container">
            <div class="row">
                <jsp:include page="navigationBarDealer.jsp" />
                <div class="col-9 centerContent">
                    <h1>Register a new Dealer</h1>
                    <form action="DealerAdd" method="POST" class="centerContent">
                        <div class="form-group">
                            <label for="dealerFN">First name:</label>
                            <input type="text" id="dealerFN" name="firstName" class="form-control">
                            <label for="dealerLN">Last name:</label>
                            <input type="text" id="dealerLN" name="lastName" class="form-control">
                            <label for="dealerWHP">Worked hour price:</label>
                            <input type="text" id="dealerWHP" name="workedHoursPrice" class="form-control">
                        </div>
                            <input type="submit" name="action" class="btn btn-primary" value="add">
                    </form>
                    <div>${message}</div>
                    <c:remove var="message" scope="session" /> 
                </div>
            </div>
        </div>
        
        <footer>
            <div class="container">
                <div class="benderLogo">
                    <h2>Casino Bender</h2>
                </div>
                <div class="footerInfo">
                    <h4>Información</h4>
                </div>
            </div>
        </footer>
        
        
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js"></script>  
    </body>
</html>
