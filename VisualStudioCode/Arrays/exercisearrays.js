let data = [
    {name: "Nacho", telephone: "966112233", age: 40},
    {name: "Ana", telephone: "911223344", age: 35},
    {name: "Mario", phone: "611998877", age: 15},
    {name: "Laura", telephone: "633663366", age: 17},
    {name: "Pedro", telephone: "611944444", age: 25},
    {name: "Julia", phone: "633232323", age: 37}
    ];

    console.log(data);

    data.sort(function (a,b){
        return a.age - b.age;
    });
    console.log("orden por edad");
    console.log(data);

    data.sort(function(a,b){
        return a.name.localeCompare(b.name);
    });
    console.log("orden por nombre");
    console.log(data);

    let menores = data.filter(function(persona){
        return persona.age >=30;
    });
    console.log("Mayores de 30");
    console.log(menores);