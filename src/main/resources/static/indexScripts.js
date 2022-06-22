function blinkText() {
    const textElement = document.getElementById("messageLabel");

    if (textElement.style.visibility === "visible") {
        textElement.style.visibility = "hidden"
    } else {
        textElement.style.visibility = "visible"
    }
}

function getFromTextField() {
    document.getElementById("fieldH6").innerHTML = document.getElementById("textField").value
}

function goToCreateNewPerson() {
    location.href="/new_person/"
}

setInterval(blinkText,300)
setInterval(getFromTextField,300)