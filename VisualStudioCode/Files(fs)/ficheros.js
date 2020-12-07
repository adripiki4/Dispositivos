const fs = require('fs');
fs.readFile('./readme.txt', 'utf8', (err, data)=>){
    if(err) throw err;
    console.log('Reading asychronous file');
    console.log(data);

    fs.writeFile('./writeme.txt', data)
}