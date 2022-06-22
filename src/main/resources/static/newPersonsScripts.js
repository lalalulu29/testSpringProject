function getValuesFromPasswordAndCheckPasswordFields() {
    const password = document.getElementById("passwordField").value;
    const checkPassword = document.getElementById("passwordCheckField").value;

    const notEqualsPassword = document.getElementById("notEqualsPassword")


    if(password.length >= 8 && checkPassword.length >= 8 && password !== checkPassword) {
        notEqualsPassword.style.visibility = "visible"
    } else {
        notEqualsPassword.style.visibility = "hidden"
    }
}

setInterval(getValuesFromPasswordAndCheckPasswordFields, 400)