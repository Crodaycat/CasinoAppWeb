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
                <jsp:include page="navigationBarMachines.jsp" />
                <div class="col-9">
                    <h1 class="centerContent">List of all machines registered</h1>
                    <form action="GetMachineType?url=consultType" method="POST" class="form-inline centerContent">
                            <div class="form-group  mx-sm-3">
                                <input type="text" id="typeId" name="id" class="form-control" placeholder="Search by machine serie">
                            </div>
                            <button type="submit" class="btn btn-primary">
                                Search <i class="fa fa-search" aria-hidden="true"></i>
                            </button>
                    </form>
                    <br>
                    
                    <div>${message}</div>
                    
                    <table class="table table-striped table-dark">
                        <thead>
                            <tr>
                              <th scope="col">Serie</th>
                              <th scope="col">Description</th>
                              <th scope="col" class="centerContent">Edit</th>
                              <th scope="col" class="centerContent">Delete</th>
                            </tr>
                        </thead>
                        <c:forEach items="${machineTypeList}" var="machineType">
                            <c:forEach items="${machineType.machineCollection}" var="machine">
                                <th scope="row">${machine.serie}</th>
                                <td>${machineType.description}</td>
                                <td class="centerContent tableLink">
                                    <a href="EditMachineType?url=edit&id=${machine.serie}">
                                        <i class="fa fa-pencil-square" aria-hidden="true"></i>
                                    </a>
                                </td>
                                <td class="centerContent tableLink">
                                    <a href="MachineTypeDelete?id=${machine.serie}">
                                        <i class="fa fa-times-circle-o" aria-hidden="true"></i>
                                    </a>
                                </td>
                            </c:forEach>
                        </c:forEach>
                    </table>
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
