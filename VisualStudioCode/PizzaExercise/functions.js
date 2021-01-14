const fs = require('fs');
let stick = document.getElementById("stick")

let ra = document.getElementById("radio1");
let ra2 = document.getElementById("radio2");
let ra3 = document.getElementById("radio3");

let i1 = document.getElementById("i1");
let i2 = document.getElementById("i2");
let i3 = document.getElementById("i3");
let i4 = document.getElementById("i4");

let button = document.getElementById("button");
button.addEventListener('click', () => {
    let comer = stick.value;
    let ingredientes = "Ingredients: ";
    let muestra = "Size: "
    if (ra.checked) {
        muestra = muestra + ra.value;
    }
    if (ra2.checked) {
        muestra = muestra + ra2.value;
    }
    if (ra3.checked) {
        muestra = muestra + ra3.value;
    }
    if (i1.checked) {
        ingredientes = ingredientes + " " + i1.value;
    }
    if (i2.checked) {
        ingredientes = ingredientes + " " + i2.value;
    }
    if (i3.checked) {
        ingredientes = ingredientes + " " + i3.value;
    }
    if (i4.checked) {
        ingredientes = ingredientes + " " + i4.value;
    }
    let result = comer + "\n" + ingredientes + "\n" + muestra

    alert(result);

    fs.writeFileSync('write.txt', result);
});

