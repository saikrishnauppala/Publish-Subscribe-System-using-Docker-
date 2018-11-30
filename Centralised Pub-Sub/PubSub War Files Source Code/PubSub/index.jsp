<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link href="css.css" type="text/css" rel="stylesheet"/>   
    <title>Phase2</title>
    <meta name="viewport" content="initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>var r;var s;</script>
<style> 
textarea {
    width: 70%;
    height: 45px;
    align: "center"
}
</style>
</head>
<body bgcolor="gray" align="center">

	<header>
      <h1>Pub/Sub Emulation</h1>
    </header>
    <form id="form1">
    <h1>Publish about a topic</h1>
          <p>
             <label>Topics</label><br>
             <select id = "myList">
               <option value = "politics">politics</option>
               <option value = "food">food</option>
               <option value = "technology">technology</option>
               <option value = "movies">movies</option>
               <option value = "sports">sports</option>
             </select>
          </p>
          <p>
          <br>
<textarea id="EC"></textarea><br>
<input type="submit" value="publish" onclick="publisher(); return false;"/>
        </p>
    </form>
    <form id="form2">
    <h1>Subscriber</h1>
    Name:
  <input type="text" id="name"><br>
    <input type="checkbox" id="politics" value="politics"> politics<br>
    <input type="checkbox" id="food" value="food"> food<br>
    <input type="checkbox" id="technology" value="technology"> technology<br>
    <input type="checkbox" id="movies" value="movies"> movies<br>
    <input type="checkbox" id="sports" value="sports"> sports<br>
  
  <input type="submit" value="subscribe" onclick="subscriber(); return false;"/>
  </form>
    <p id="demo"></p>
    <p id="demo1"></p>    
    <script>
   
function publisher() {
  newDetails = {topic: document.getElementById('myList').value, message: document.getElementById('EC').value};
	  $.ajax({
		  'async': false,
		  type: "POST",
	      url: "publish",
	      data: newDetails,
	   	  success: function(result){
	   		  r = result;
	   		  console.log(result);	   		
	   	  }
	  });	  
	 alert(r);
}
function subscriber(){
	newDetails = {name: document.getElementById('name').value, 
			politics: document.getElementById('politics').checked,
			food: document.getElementById('food').checked,
			technology: document.getElementById('technology').checked,
			movies: document.getElementById('movies').checked,
			sports: document.getElementById('sports').checked};
	  $.ajax({
		  'async': false,
		  type: "POST",
	      url: "subscribe",
	      data: newDetails,
	   	  success: function(result){	   		 
	   		  s = result;
	   	  }
	  });	  
	 alert(s);
}
</script>
  </body>
</html>