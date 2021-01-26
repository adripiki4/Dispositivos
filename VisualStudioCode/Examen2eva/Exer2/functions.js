let preciouni = document.getElementById("preciouni");
let cantidad = document.getElementById("cantidad");
let limpiar = document.getElementById("limpiar");
let calcular = document.getElementById("calcular");
let salir = document.getElementById("salir");
let precioparcial = document.getElementById("precioparcial");
let descuento = document.getElementById("descuento");
let precioneto = document.getElementById("precioneto");

limpiar.addEventListener('click', () =>{
    preciouni.value = "";
    cantidad.value ="";
    precioparcial.value ="";
    descuento.value ="";
    precioneto.value ="";
})
salir.addEventListener('click', ()=>{
    close();
})

calcular.addEventListener('click',()=>{
    let total = parseFloat(preciouni.value) * parseInt(cantidad.value);
    let descontar = (total * parseFloat(descuento.value))/100;
    let result = total - descontar
    precioparcial.value = total
    precioneto.value = result
})
