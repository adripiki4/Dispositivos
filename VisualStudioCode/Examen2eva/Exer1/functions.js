const fs = require('fs');

let name = document.getElementById("name");
let surname = document.getElementById("surname");
let sons = document.getElementById("sons");
let daughters = document.getElementById("daughters");
let result = document.getElementById("result");
let male = document.getElementById("masc");
let female = document.getElementById("fem");

let button = document.getElementById("button");


button.addEventListener('click',()=>{
    let sex ="";
    if(male.checked){
        sex = "Male";
    }else if (female.checked){
        sex ="Female";
    }
    let mostrar = "NAME: "+name.value+ "\n" + "SURNAME: " +surname.value+ "\n" +"SONS:"+sons.value+ "\n" +"DAUGHTERS: "+daughters.value+ "\n" +"SEX: "+sex;
    result.value =  mostrar;
    fs.writeFileSync('write.txt',mostrar);

})