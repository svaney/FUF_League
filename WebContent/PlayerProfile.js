function popup() {
alert("Hello World");
}

function ClickHandler() {
    var input = document.getElementById("nameInput").value;
    var output = "სალამი, " + input + "!";
    document.getElementById("nameInput").value = "";
    document.getElementById("greetingOutput").innerText = output;
}