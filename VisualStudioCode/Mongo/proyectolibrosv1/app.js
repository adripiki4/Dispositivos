
const mongoose = require('mongoose');
mongoose.Promise = global.Promise;
//conexión
const url1 = 'mongodb://localhost:27017/libros';
//MongoAtlas
const url2 = 'mongodb+srv://adriba:piqui4@cluster0.chpgt.mongodb.net/libros?retryWrites=true&w=majority';
mongoose.connect(url2, {
    useNewUrlParser: true,
    useUnifiedTopology: true
});
//esquema
let librosSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    author: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    img: {
        type: String,
        required: true,
        minlength: 1,
        unique: true,
        trim: true
    }
});

//modelo
let Libro = mongoose.model('libros', librosSchema);
todos();

//busqueda con find
function todos(){
    let p1 = Libro.find().then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(book => {
            cadenaDOM +=
                `<div>
                    <x-box vertical>
                        <img src="./images/${book.img}" height="170" width="108">
                        <x-label><strong>${book.title}</strong></x-label>
                        <x-label>${book.author}</x-label>
                    </x-box>
                </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("ERROR en find");
    });
}

/*let p1 = Libro.find().then(resultado => {
    let cadenaDOM = "";
    resultado.forEach(book => {
        cadenaDOM +=
            `<div>
                <x-box vertical>
                    <img src="./images/${book.img}" height="170" width="108">
                    <x-label><strong>${book.title}</strong></x-label>
                    <x-label>${book.author}</x-label>
                </x-box>
            </div>`;
    });
    document.getElementById("wrapper").innerHTML = cadenaDOM;
}).catch(error => {
    console.log("ERROR en find");
});*/



//Buscar por Titulo del libro
document.getElementById("btnbuscar").addEventListener('click',()=>{
    let txtbuscar = document.getElementById("txtbuscar").value;
    Libro.find({title:{$regex:'.*'+txtbuscar+'.*'}}).then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(book => {
            cadenaDOM +=
                `<div>
                    <x-box vertical>
                        <img src="./images/${book.img}" height="170" width="108">
                        <x-label><strong>${book.title}</strong></x-label>
                        <x-label>${book.author}</x-label>
                    </x-box>
                </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("ERROR en find");
    });
    document.getElementById("txtbuscar").value = "";
})

//Buscar por nombre de Autor
document.getElementById("btnautor").addEventListener('click',()=>{
    let txtautor = document.getElementById("txtautor").value;
    Libro.find({author:{$regex:'.*'+txtautor+'.*'}}).then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(book => {
            cadenaDOM +=
                `<div>
                    <x-box vertical>
                        <img src="./images/${book.img}" height="170" width="108">
                        <x-label><strong>${book.title}</strong></x-label>
                        <x-label>${book.author}</x-label>
                    </x-box>
                </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("ERROR en find");
    });
    document.getElementById("txtautor").value = "";
})

document.getElementById("btnhome").addEventListener('click',()=>{
    todos();
})

//escuchador del boton nuevo libro
document.getElementById("btnNuevoLibro").addEventListener('click', () => {
    let txtNuevoTitulo = document.getElementById("txtNuevotitulo").value;
    let txtNuevoAutor = document.getElementById("txtNuevoAutor").value;
    let txtNuevaImagen = document.getElementById("txtNuevaImagen").value;
    if (txtNuevoTitulo == "" || txtNuevoAutor == "" || txtNuevaImagen == "") {
        let notification = document.querySelector("#notification");
        notification.innerHTML = "Debe escribir algo";
        notification.opened = true;
    } else {
        //Insertamos el libro
        let libro = new Libro({
            title: txtNuevoTitulo,
            author: txtNuevoAutor,
            img: txtNuevaImagen
        });
        libro.save().then(resultado => {
            let notification = document.querySelector("#notification");
            notification.innerHTML = "Libro Añadido";
            notification.opened = true;
            todos();
        }).catch(error => {
            let notification = document.querySelector("#notification");
            notification.innerHTML = "NO se ha podido añadir el libro";
            notification.opened = true;
        });
    }
    
});

//Borrar libro
document.getElementById("btnborrar").addEventListener('click',()=>{
    let txtborrar = document.getElementById("txtborrar").value
    Libro.remove({title:txtborrar}).then(resultado=>{
        let notification = document.querySelector("#notification");
        notification.innerHTML = "Libro Borrado";
        notification.opened = true;
    }).catch(error=>{
        let notification = document.getElementById("#notification");
        notification.innerHTML = "NO se ha podido borrar el libro";
        notification.opened = true;
    });
    todos();
})

