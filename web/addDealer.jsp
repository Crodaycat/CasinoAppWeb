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
        
        <nav>
            <a href="#">Home 
                <i class="fa fa-home" aria-hidden="true"></i>
            </a>
            <a href="#">
                Dealers Manager 
                <i class="fa fa-users" aria-hidden="true"></i>
            </a>
            <a href="#" >
                Machines Manager
                <i class="fa fa-gamepad" aria-hidden="true"></i>
            </a>
            <a href="#">
                Awards Manager 
                <i class="fa fa-krw" aria-hidden="true"></i>
            </a>
            <a href="#">
                Games History 
                <i class="fa fa-file-text" aria-hidden="true"></i>
            </a>
        </nav>
        
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="AddDealer" method="POST">
                        <table>
                            <tr>
                                <th><label for="dealerId">Dealer id: </label></th>
                                <th><input type="text" id="dealerId" name="id" value="${dealer.id}" class="form-control"></th>
                            </tr>
                            <tr>
                                <th><label for="dealerFN">First name: </label></th>
                                <th><input type="text" id="dealerFN" name="firstName" value="${dealer.firstName}" class="form-control"></th>
                            </tr>
                            <tr>
                                <th><label for="dealerLN">Last name: </label></th>
                                <th><input type="text" id="dealerLN" name="lastName" value="${dealer.lastName}" class="form-control"></th>
                            </tr>
                            <tr>
                                <th><label for="dealerBM">Base money: </label></th>
                                <th><input type="text" id="dealerBM" name="baseMoney" value="${dealer.baseMoney}" class="form-control"></th>
                            </tr>
                            <tr>
                                <th><label for="dealerWH">Worked hours: </label></th>
                                <th><input type="text" id="dealerWH" name="workedHours" value="${dealer.workedHours}" class="form-control"></th>
                            </tr>
                            <tr>
                                <th><label for="dealerFP">Financial profit: </label></th>
                                <th><input type="text" id="dealerFP" name="financialProfit" value="${dealer.financialProfit}" class="form-control"></th>
                            </tr>
                        </table>
                            <input type="submit" name="action" class="btn btn-primary" value="add">
                    </form>
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
