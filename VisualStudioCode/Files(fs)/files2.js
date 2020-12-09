const http=require('http');
var server = http.createServer(function(req,res){
    console.log(req.url);
    res.writeHead(200, {'Content-type': 'application/json'});
    var miObj = {
        nombre: 'pepe',
        trabajo: 'programador',
        edad: 35
    }
    res.end(JSON.stringify(miObj));
});