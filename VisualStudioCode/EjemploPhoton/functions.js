// assign text field to a variable
let text = document.getElementById("text");

let button = document.getElementById("button");
button.addEventListener('click', () => {
    alert(text.value);
});

// text field event
text.addEventListener('click ', () => {
 alert ("Click in text field!");
});
text.addEventListener('keyup', (event) => {
    console.log(event.code);
    if (event.code == "Enter") {
        sample.innerHTML=text.value;
    }
});