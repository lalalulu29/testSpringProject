        function blink() {
            var textElement = document.getElementById("messageLabel")
            console.log(textElement.style.visibility)
            if (textElement.style.visibility == "visible") {
                textElement.style.visibility = "hidden"
            } else {
                textElement.style.visibility = "visible"
            }
        }

        function getFromTextField() {
            var textElement = document.getElementById("textField").value

            document.getElementById("fieldH6").innerHTML = textElement
            console.log(textElement)
        }

        setInterval(blink,300)
        setInterval(getFromTextField,300)