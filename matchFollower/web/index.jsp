<%-- 
    Document   : index2
    Created on : 2018-07-27, 10:34:04
    Author     : jvict
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- verificar <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="js/js.js" type="text/javascript"></script>
        <title>JSP and JSON</title>

    </head>
    <body>
        <div class="container"> 
            <div class="row">
                <div class="col-xl-3"></div>
                    <div class="col-xl-6 text-center"> 
                        <h1 class="text-center">World Cup 2022</h1>
                        <div id="matches"></div>
                        <input type="button" value="Search Matches" id="searchMatches" />
                    </div>
                <div class="col-xl-3"></div>    
            </div>
        </div>
        <script>            
            console.log(${sessionScope.jsonR});
        </script>
    </body>
    
</html>