function save()
{
    var userListe = document.getElementById('userC');
    var userSelIndex = userListe.selectedIndex;
    var userSelValue = userListe.options[userListe.selectedIndex].value;
    var userSelText = userListe.options[userListe.selectedIndex].text;
        
    var sessionListe = document.getElementById('sessionC');
    var sessionSelIndex = sessionListe.selectedIndex;
    var sessionSelValue = sessionListe.options[sessionListe.selectedIndex].value;
    var sessionSelText = sessionListe.options[sessionListe.selectedIndex].text;
    
    var scoreListe = document.getElementById('scoreC');
    var scoreSelIndex = scoreListe.selectedIndex;
    var scoreSelValue = scoreListe.options[scoreListe.selectedIndex].value;
    var scoreSelText = scoreListe.options[scoreListe.selectedIndex].text;

   var usersSessionsScores=(sessionStorage.usersSessionsScores)?sessionStorage.usersSessionsScores
        							+' <tr><td>'+userSelText+'</td>'
        							+'<td>'+sessionSelText+'</td>'
        							+'<td>'+scoreSelText+'</td> </tr>':
        							'<th>Utilisateur(s)</th><th> Session(s)</th><th>Note(s)</th><tr><td>'+userSelText+'</td>'
        							+'<td>'+sessionSelText+'</td>'
        							+'<td>'+scoreSelText+'</td></tr>';
    
     sessionStorage.usersSessionsScores=usersSessionsScores;
   						
     document.getElementById('usersSessionsScores').innerHTML = sessionStorage.usersSessionsScores;
    
}