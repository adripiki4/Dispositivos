let dianumero = document.getElementById("dianumero");
let dianombre = document.getElementById("dianombre");

let limpiar = document.getElementById("limpiar");
let calcular = document.getElementById("calcular");
let salir = document.getElementById("salir");

limpiar.addEventListener('click', () =>{
    dianumero.value = "";
    dianombre.value ="";
})

calcular.addEventListener('click', () =>{
    if(dianumero.value==1){
        dianombre.value= "Lunes";
    }
    else if(dianumero.value==2){
        dianombre.value= "Martes";
    }
    else if(dianumero.value==3){
        dianombre.value= "Miercoles";
    }
    else if(dianumero.value==4){
        dianombre.value= "Jueves";
    }
    else if(dianumero.value==5){
        dianombre.value= "Viernes";
    }
    else if(dianumero.value==6){
        dianombre.value= "Sabado";
    }
    else if(dianumero.value==7){
        dianombre.value= "Domingo";
    }
    else if(dianumero.value<1 || dianumero.value>7){
        dianombre.value = "Numero incorrecto";
    }
})

salir.addEventListener('click', ()=>{
    close();
})
