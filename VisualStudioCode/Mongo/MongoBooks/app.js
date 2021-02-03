const { error } = require("console");
const fs = require("fs"); 
//Read

// Read books.json file 
let fichero = fs.readFileSync('./books.json',);
let books = JSON.parse(fichero);


// we load moongose
const mongoose=require('mongoose');
// we set the default promise engine to javascript
// this is necessary because mongo supports different types of promises
mongoose.Promise=global.Promise;
// connect with the contacts DB
mongoose.connect('mongodb://localhost:27017/libros', {
useNewUrlParser:true,
useUnifiedTopology:true
});

//scheme
//esquem
let BookSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    author: {
        type: String,
        required: true,
        trim: true,
        
    },
    img: {
        type: String,
        required: true,
        trim: true,
        unique: true
    }
});

//model
let book = mongoose.model('libros', BookSchema);
let p1
books.forEach(element => {
    let Book = new book();
        Book.title= element.title;
        Book.author = element.author;
        Book.img = element.img;
        p1 = Book.save().then(resultado =>{
            console.log("Book id added: ", resultado);
        }).catch(error=>{
            console.log(error);
        })

});




