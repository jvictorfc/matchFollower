<%-- 
    Document   : index
    Created on : 2018-07-26, 12:50:13
    Author     : jvict
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Follow Matches in real time</title>
    </head>
    <body>
        onload="getMatches()"
        <h1>Matches Live</h1>
        <div id="results"></div>
        
        <script>
          //AJAX request to the servlet  
          function getMatches(){
                var url = "mfsl?action=matches;                
                request = new XMLHttpRequest();                
                request.open("GET", url, true);                 
                request.onreadystatechange = callback;               
                request.send(null);
          }
          
          function callback() {
                if (request.readyState === 4){
                    if(request.status === 200){
                        parseMessages(request.responseXML);
                    }
                }
          }
          
          function parseMatches(responseJSON){
              
          }
            
        </script>    
        
    </body>
</html>
