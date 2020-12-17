console.log('from index.js');

const BrowserWindow=require('electron').remote.BrowserWindow;
const path = require('path');
const url = require('url');


let secondwindow=new BrowserWindow({
    webPreferences: {
        nativeWindowOpen: true,
        nodeIntegration: true,

    },
});

secondwindow.loadURL(url.format({
    pathname: path.join(__dirname, 'secondwindow.html'),
    protocol: 'file',
    slashes: true
}));

secondwindow.webContents.openDevTools();
secondwindow.on('closed', () => {
    secondwindow = null;
})
