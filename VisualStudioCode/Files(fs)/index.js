const fs = require("fs"); 
   
// Read users.json file 
fs.readFile("clientes.json", function(err, data) { 
      
    // Check for errors 
    if (err) throw err; 
   
    // Converting to JSON 
    const clientes = JSON.parse(data); 
      
    console.log(clientes); // Print users  
}); 