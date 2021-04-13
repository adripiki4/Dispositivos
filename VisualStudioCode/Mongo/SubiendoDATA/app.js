const { error } = require("console");
const fs = require("fs"); 
//Read

// Read books.json file 
let fichero = fs.readFileSync('./songs.json',);
let songs = JSON.parse(fichero);

// we load moongose
const mongoose=require('mongoose');
// we set the default promise engine to javascript
// this is necessary because mongo supports different types of promises
mongoose.Promise=global.Promise;
// connect with the contacts DB
const url1 ='mongodb://localhost:27017/songs';
const url2 = 'mongodb+srv://adriba:piqui4@cluster0.chpgt.mongodb.net/songs?retryWrites=true&w=majority';
mongoose.connect(url2, {
useNewUrlParser:true,
useUnifiedTopology:true
});

//scheme
let SongsSchema = new mongoose.Schema({
    name:{
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    artist:{
        type: String,
        required: true,
        trim: true,
    },
    album:{
        type: String,
        required: true,
        trim: true,
    },
    type: {
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
let song = mongoose.model('songsv4', SongsSchema);
let p1;
songs.forEach(element =>{
    let Song = new song();
        Song.name = element.name;
        Song.artist = element.artist;
        Song.album = element.album;
        Song.type = element.type;
        Song.img = element.img;
        p1 = Song.save().then(resultado =>{
            console.log("Song added: ", resultado);
        }).catch(error=>{
            console.log(error);
        })

});
