const fs = require('fs');
let name = document.getElementById("name");
let email = document.getElementById("email");
let telephone = document.getElementById("telephone");
let adress = document.getElementById("adress");
let creditnumber = document.getElementById("creditnumber");
let provider = document.getElementById("provider");
let male = document.getElementById("masc");
let female = document.getElementById("fem");

let button = document.getElementById("button");


button.addEventListener('click',() =>{
    let genre="";
    if(male.checked){
        genre = male.value;
    }else if(female.checked){
        genre = female.value;
    }
    let muestra ="NAME :"+name.value +"\n"+"EMAIL: "+email.value+"\n"+"TELEPHONE: "+telephone.value+"\n"+"ADRESS: "+adress.value
    +"\n"+"CREDIT CARD NUMBER: "+creditnumber.value+"\n"+ "CREDIT CARD PROVIDER: " +provider.value+"\n"+"GENDER: "+genre;

    fs.writeFileSync('write.txt',muestra);



})


