let kelvin = document.getElementById("txtkelvin");
let celsius = document.getElementById("txtcelsius");
let limpiar = document.getElementById("limpiar");
let convertir = document.getElementById("convertir");

limpiar.addEventListener('click', (event) => {
    kelvin.value = "";
    celsius.value = "";
})

convertir.addEventListener('click', (event) => {
    if (kelvin.value == "") {
        kelvin.value = parseFloat(celsius.value) + 273.15;;
    }
    else if (celsius.value == "") {
        celsius.value = (parseFloat(kelvin.value) - 273.15);
    }
})