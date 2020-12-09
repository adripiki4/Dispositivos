let http = require('http')

//Leer clientes del fichero
let fichero = require('./clientes.json');

http.createServer(function(req,res){
    res.writeHead(200,{'Content-Type': 'application/json'})
    res.end(JSON.stringify(fichero))
}).listen(3000, "127.0.0.1")
console.log('Server running at http://127.0.0.1:3000/');