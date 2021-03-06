const { app, BrowserWindow } = require('electron')

function createWindow() {
    const mainWindow = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true
        }
    })
    // remove default chromium menu
    mainWindow.setMenu(null);

    mainWindow.loadFile('index.html')
    // Open the DevTools.
    //mainWindow.webContents.openDevTools ()
}

app.on('ready', createWindow);

//Alternative way to app on
//app.whenReady().then(createWindow);