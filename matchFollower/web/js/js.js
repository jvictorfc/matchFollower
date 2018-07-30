     
    function searchMatches(){
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
    }
    
    //Showing searched matches
    function showMatches(matches){
            //$("#matches").html("");
            var content="";
            content = "<table class='table table-striped table-ligth text-center' > <thead class='thead-dark'> <tr><th>Id Match</th>  <th class='text-right'>Team 1</th> <th></th> <th>Team 2</th></tr></thead>";
            $("#matches").html(content);
        for(var i=0; i<matches.length; i++){
            content += "<tr><td>"+matches[i].idM+"</td>" +"<td class='text-right'>" +matches[i].t1 +"</td>" +"<td>" +matches[i].t1r +" <b>X</b> " +matches[i].t2r +"</td>" +"<td>" +matches[i].t2 +"</td>"
           $("#matches").html(content);
        }
        $("#matches").append("</table>");
    }
   
   //Attaching onclick event to Search Matches button  
   $(document).ready(function(){
                    $("#searchMatches").click(function () {
                        searchMatches();
                    });
                });
                
                
