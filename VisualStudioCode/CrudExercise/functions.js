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

let mostrarbtn = false;
let position = 0
let mostrarClienete = ()=>{
    document.getElementById('dni').value = customers[position].dni
    document.getElementById("nombre").value = customers[position].Name
    document.getElementById("telefono").value = customers[position].telephone
}

mostrarClienete();

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
    if(position==(customers.length-1)){
        position = customers.length -1;
    }else{
        position= position +1;
    }
    mostrarClienete();
})

btnultimo.addEventListener('click', ()=>{
    position= customers.length-1;
    mostrarClienete();
})
 
btnborrar.addEventListener('click', ()=>{
    customers.splice(position,1);

    //Si borra la ultima posicion, el array tendra un valor menos, por la tanto la posicion anterior ya no será .length-1 si no .length
    if(position==(customers.length)){
        position = position -1;
    }else{
        position= position = 0;
    }

    if(customers.length==0){
        document.getElementById('dni').value = "";
        document.getElementById('nombre').value = "";
        document.getElementById('telefono').value = "";
    }
    mostrarClienete();
    //actulizarfichero();
})

btnactualizar.addEventListener('click', ()=>{
    //obtiene los datos de la pantalla
    customers[position].dni = document.getElementById('dni').value;
    customers[position].Name = document.getElementById('nombre').value
    customers[position].telephone = document.getElementById('telefono').value
    actulizarfichero();
})

let actulizarfichero = () =>{
    fs.writeFileSync('./customers.json',JSON.stringify(customers));
}

btninsertar.addEventListener('click',()=>{
    ocultarbtns();
    let nuevo = {}
    if(mostrarbtn== false){
        document.getElementById('dni').value = "";
        document.getElementById('nombre').value = "";
        document.getElementById('telefono').value = "";
        mostrarbtn = true
        //Cambia la clase de btn
        btninsertar.classList.remove("btn-primary")
        btninsertar.classList.add("btn-negative")
    }else{
        nuevo={
            dni: document.getElementById('dni').value,
            Name: document.getElementById('nombre').value,
            telephone: document.getElementById('telefono').value
        }
    }
 

})

let ocultarbtns = () =>{

    if(mostrarbtn==false){
        btnprimero.disable.true;
        btnatras.disable.true;
        btnadelante.disable.true;
        btnultimo.disable.true;
        btnborrar.disable.true;
        btnactualizar.disable.true;

    
    }
}



