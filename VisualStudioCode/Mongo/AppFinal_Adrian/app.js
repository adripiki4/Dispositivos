const mongoose = require('mongoose');
mongoose.Promise = global.Promise;
//conexión
const url1 = 'mongodb://localhost:27017/songs';
const url2 = 'mongodb+srv://adriba:piqui4@cluster0.chpgt.mongodb.net/songs?retryWrites=true&w=majority';
mongoose.connect(url2, {
    useNewUrlParser: true,
    useUnifiedTopology: true
});


//schema
let SongsSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    artist: {
        type: String,
        required: true,
        trim: true,
    },
    album: {
        type: String,
        required: true,
        trim: true,
    },
    type: {
        type: String,
        trim: true,
    },
    img: {
        type: String,
        required: true,
        trim: true,
        
    }
});

//modelo
let song = mongoose.model('songs', SongsSchema);
todos();

//Busqueda con find
function todos() {
    let p1 = song.find().then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(item => {
            cadenaDOM +=
                `<div>
            <x-box vertical>
                <img src="./images/${item.img}" height="150" width="150">
                <x-label><strong>${item.name}</strong></x-label>
                <x-label>${item.artist}</x-label>
                <x-label>${item.album}</x-label>
            </x-box>
        </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("Error en find");
    });
}

//Buscar cancion por nombre
document.getElementById("btnbuscar1").addEventListener('click', () => {
    let txtbuscar = document.getElementById("txtname").value;
    song.find({ name: { $regex: '.*' + txtbuscar + '.*' } }).then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(item => {
            cadenaDOM +=
                `<div>
            <x-box vertical>
                <img src="./images/${item.img}" height="150" width="150">
                <x-label><strong>${item.name}</strong></x-label>
                <x-label>${item.artist}</x-label>
                <x-label>${item.album}</x-label>
            </x-box>
        </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("Error en find by name");
    });
    document.getElementById("txtname").value = "";
})



//Buscar por artista
document.getElementById("btnbuscar2").addEventListener('click', () => {
    let txtartist = document.getElementById("txtartist").value;
    song.find({ artist: { $regex: '.*' + txtartist + '.*' } }).then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(item => {
            cadenaDOM +=
                `<div>
            <x-box vertical>
                <img src="./images/${item.img}" height="150" width="150">
                <x-label><strong>${item.name}</strong></x-label>
                <x-label>${item.artist}</x-label>
                <x-label>${item.album}</x-label>
            </x-box>
        </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("Error en find by name");
    });
    document.getElementById("txtartist").value = "";
})

//New song
document.getElementById("btnnew").addEventListener('click', () => {
    let newname = document.getElementById("newname").value;
    let newartist = document.getElementById("newartist").value;
    let newalbum = document.getElementById("newalbum").value;
    let newimg = document.getElementById("newimg").value;
    if (newname == "" || newartist == "" || newalbum == "" || newimg == "") {
        let notification = document.querySelector("#notification");
        notification.innerHTML = "Debe escribir algo";
        notification.opened = true;
    }else{
        //Insertamos la cancion
        let newsong = new song({
            name: newname,
            artist: newartist,
            album: newalbum,
            img: newimg
        });
        newsong.save().then(resultado =>{
            let notification = document.querySelector("#notification");
            notification.innerHTML = "New Song Added";
            notification.opened = true;
            todos();
        }).catch(error => {
            let notification = document.querySelector("#notification");
            notification.innerHTML = "NO se ha podido añadir el libro";
            notification.opened = true;
        });
    }

});


//Delete
document.getElementById("btndelete").addEventListener('click',()=>{
    let txtborrar = document.getElementById("txtdelete").value
    song.remove({name:txtborrar}).then(resultado=>{
        let notification = document.querySelector("#notification");
        notification.innerHTML = "Delete Successful";
        notification.opened = true;
    }).catch(error=>{
        let notification = document.getElementById("#notification");
        notification.innerHTML = "NO se ha podido borrar el libro";
        notification.opened = true;
    });
    todos();
})

//Boton home
document.getElementById("btnhome").addEventListener('click',()=>{
    todos();
})