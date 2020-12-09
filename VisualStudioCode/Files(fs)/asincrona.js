const fs = require('fs');

fs.readFile('./readme.txt', 'utf8', (err, data) => {
    if (err) throw err;
    console.log('Reading asynchronous files');
    console.log(data);


    fs.writeFile('./writeme.txt', data, (err) => {
        if (err) throw err;
        err
            ? console.log(err)
            : console.log('File written correctly');
    })
});

//fs.unlink('./writeme.txt',
//(err)=>{if (err)throw err;
//console.log('writeme.txt was deleted');
//});