function blinkText() {
    const textElement = document.getElementById("messageLabel");
    console.log(textElement.style.visibility)
    if (textElement.style.visibility === "visible") {
        textElement.style.visibility = "hidden"
    } else {
        textElement.style.visibility = "visible"
    }
}

function getFromTextField() {
    const textElement = document.getElementById("textField").value;

    document.getElementById("fieldH6").innerHTML = textElement
    console.log(textElement)
}

function goToCreateNewPerson() {
    location.href="/new_person/"
}

setInterval(blinkText,300)
setInterval(getFromTextField,300)