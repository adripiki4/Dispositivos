const fs = require('fs')

let btnprimero = document.getElementById('btnprimero')
let btnatras = document.getElementById('btnatras')
let btnadelante = document.getElementById('btnadelante')
let btnultimo = document.getElementById('btnultimo')
let btnborrar = document.getElementById('btnborrar')
let btninsertar = document.getElementById('btninsertar')
let btnactualizar = document.getElementById('btnactualizar')

let file = fs.readFileSync('./customers.json');
// array to manipulate the data
let customers = new Array()
// parse the file in json format
// now in the clients array we will have a vector
// where in each position of the vector there is an object
// with the data of a client
customers = JSON.parse(file);

let position = 0
let mostrarClienete = ()=>{
    document.getElementById('dni').value = customers[position].dni
    document.getElementById("nombre").value = customers[position].Name
    document.getElementById("telefono").value = customers[position].telephone
}

btnprimero.addEventListener('click', ()=>{
    position= 0;
    mostrarClienete();
})

btnatras.addEventListener('click',()=>{
    if(position==0){
        position = 0;
    }else{
        position = position -1;
    }
    mostrarClienete();
})

btnadelante.addEventListener('click', ()=>{
    position= position +1;
    mostrarClienete();
})

btnultimo.addEventListener('click', ()=>{
    position= customers.length-1;
    mostrarClienete();
})
 
btnborrar.addEventListener('click', ()=>{
    position= 0;
    mostrarClienete();
})



