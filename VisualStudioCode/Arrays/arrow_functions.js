let data = [
    {name: "Nacho", phone: "966112233", age: 40},
    {name: "Ana", phone: "911223344", age: 35},
    {name: "Mario", phone: "611998877", age: 15},
    {name: "Laura", phone: "633663366", age: 17}
    ];



//AÑadir persona
let NewPerson = person =>{
    aux = data.filter(p => p.phone === person.phone);
    if(aux.length ==0){
        data.push(person);
    }
}

//Borrarpersona
let borrarPerson = phone =>{
  
data = data.filter(person => person.phone != phone);
}

//Programa principal
NewPerson ({name: "Juan", phone: "965661564", age: 60});
NewPerson ({name: "Rodolfo", phone: "910011001", age: 20});
borrarPerson("910011001");
console.log(data);
