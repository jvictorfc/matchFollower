
var messagesWaiting = false;     
    function searchMatches(){
            if(!messagesWaiting){
        messagesWaiting = true;
        $.ajax ({
            url      : "mfsl",
            data : "action=push",
            type     : "GET",
           // cache    : false,
            dataType : "json",
            success  : function(results) {
                           messagesWaiting = false;
                           showMatches(results);
                       },
            error    : function(results) {
                //Create error handling option
                           console.log(JSON.stringify(results));
                       }
        });
    }
}
            setInterval(searchMatches, 1000);
            
    function showMatches(matches){
            var content="";
            content = "<table class='table table-striped table-ligth text-center' > <thead class='thead-dark'> <tr><th>Id Match</th>  <th class='text-right'>Team 1</th> <th></th> <th>Team 2</th></tr></thead>";
            $("#matches").html(content);
        for(var i=0; i<matches.length; i++){
            content += "<tr><td>"+matches[i].idM+"</td>" +"<td class='text-right'>" +matches[i].t1.name +"</td>" +"<td>" +matches[i].t1r +" <b>X</b> " +matches[i].t2r +"</td>" +"<td>" +matches[i].t2.name +"</td>"
           $("#matches").html(content);
        }
        $("#matches").append("</table>");
    }
   
   //Attaching onclick event to Search Matches button  
   $(document).ready(function(){
                   showMatches(initMatches);
                    //initialMatches();
                    $("#searchMatches").click(function () {
                        searchMatches();
                    });
                });
                            

//            function searchMatches() {
//                    console.log("Conteur: " + messagesWaiting);
//                if (messagesWaiting == false) {
//                    console.log("Requete fait pour verifier:" + messagesWaiting);
//                    messagesWaiting = true;
//                    var xmlhttp = new XMLHttpRequest();
//                    xmlhttp.onreadystatechange = function () {
//                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//                            console.log("Nouvelle message: " + messagesWaiting);
//                            messagesWaiting = false;
//                            console.log("noveau resultat");
//                            console.log(xmlhttp);
//                            var resp = JSON.parse(this.responseText);
//                            showMatches(resp);
//                        }
//                    }
//                    xmlhttp.open("GET", "mfsl?action=push", true);
//                    xmlhttp.send();
//                }
//            }
            

            
//    function initialMatches(){
//            //if(messagesWaiting == false){
//       // messagesWaiting = true;
//        $.ajax ({
//            url      : "mfsl",
//            data : "action=matches",
//            type     : "GET",
//           // cache    : false,
//            dataType : "json",
//            success  : function(results) {
//                           //messagesWaiting = false;
//                           showMatches(results);
//                       },
//            error    : function(results) {
//                //Create error handling option
//                           console.log(JSON.stringify(results));
//                       }
//        });
//    }
//}

    //Showing searched matches

                
