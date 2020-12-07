const http=require('http');

var server = http.createServer(function(req,res){
    console.log(req.url);
    res.writeHead(200,{'Content-hype': 'application/json'});
    var miobj={
        nombre:'pepe',
        trabajo:'programador',
        edad:35
    }
    res.end(JSON.stringify(miobj));
    console.log(typeof(JSON.stringify(miobj)));
});
server.listen(3001, '127.0.0.1');