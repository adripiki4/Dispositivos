const http=require('http');
var server = http.createServer(function(req,res){
    res.writeHead(200,{'Content-hype': 'text/plain'});
    res.end('hola clase');
});

server.listen(3000, '127.0.0.1');
