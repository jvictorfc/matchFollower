<%-- 
    Document   : matMgr
    Created on : 2018-07-30, 11:41:02
    Author     : jvict
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Match Mananger</title>
    </head>
    <body>
        <div id="happening"></div>       
    <script>
            $(document).ready(function(){
        $.ajax ({
            url      : "mfsl",
            data : "action=matches",
            type     : "GET",
            cache    : false,
            dataType : "json",
            success  : function(results) {
                           showMatches(results);
                       },
            error    : function(results) {
                //Create error handling option
                           console.log(JSON.stringify(results));
                       }
        });
    });
    
    //Showing searched matches
    function showMatches(matches){
        
            var place="#happening";
        $(place).html("");
            var content="";
            content = "<table class='table table-striped table-ligth text-center' > <thead class='thead-dark'> <tr><th>Id Match</th>  <th class='text-right'>Team 1</th> <th></th> <th>Team 2</th></tr></thead>";
            $(place).html(content);
        for(var i=0; i<matches.length; i++){
            var id = matches[i].idM;
            var t1 = matches[i].t1.name;
            var t2 = matches[i].t2.name;
            var t1id = matches[i].t1.id;
            var t2id = matches[i].t2.id;
            var t1r = matches[i].t1r;
            var t2r = matches[i].t2r;
            content += "<tr><td>"+id+"</td><td class='text-right'>" +t1 +"<a target='_blank' href='mfsl?action=result&id="+id+"&func=add&team="+t1id+"'>+</a>" 
                    +"<a href='mfsl?action=result&id="+id+"&func=rem&team="+t1id+"'>-</a>" +"</td><td>" +t1r +" <b>X</b> " +t2r +"</td><td>" +t2 +"<a target='_blank' href='mfsl?action=result&id="+id+"&func=add&team="+t2id+"'>+</a>" 
                    +"<a href='mfsl?action=result&id="+id+"&func=rem&team="+t2id+"'>-</a>" +"</td></tr>";
           $(place).html(content);
        }
        $(place).append("</table>");
    }

    </script>    
    </body>
</html>
