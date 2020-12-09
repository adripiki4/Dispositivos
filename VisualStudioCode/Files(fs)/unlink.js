const fs = require('fs');

fs.unlink('./writeme.txt',
(err)=>{if (err)throw err;
console.log('writeme.txt was deleted');
});