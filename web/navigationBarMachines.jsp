<%-- 
    Document   : navigationBarMachines
    Created on : Nov 27, 2017, 8:20:57 AM
    Author     : luis.giraldo10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-3 crudMenu">
            <a href="addMachineType.jsp">
                Add a new machine type 
                <i class="fa fa-plus-circle" aria-hidden="true"></i>
            </a>
            <a href="GetMachineTypes?url=addMachine">
                Add a new machine
                <i class="fa fa-plus-circle" aria-hidden="true"></i>
            </a>
            <a href="GetMachineTypes?url=addAward">
                Add a new award
                <i class="fa fa-plus-circle" aria-hidden="true"></i>
            </a>
        </div>
    </body>
</html>
