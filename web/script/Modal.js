var btnLoginRegister = document.getElementById('button-login-register');
var btnClose = document.getElementById('button-close');

btnLoginRegister.addEventListener("click", function () {
    setVisible('sign-up', true);
    setVisible('login-bar', false);

});

function validate() {
    var email = document.getElementById("email_address").value;
    var password = document.getElementById("psw").value;
    var e;
    if (validatePassword(password) && validateEmail(email)) {
        alert("REGISTRATION SUCCESS");
        closeSignUpMenu();
        return true;
    } else {
        e.preventDefault();
    }
    return false;
}

btnClose.addEventListener("click", function () {
    closeSignUpMenu();

});

function validatePassword(password) {
    var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    var passwordRepeat = document.getElementById("psw-repeat").value;

    if (password.trim() == passwordRepeat.trim() && password.match(decimal)) {
        return true;
    } else {
        alert("Check a password between 6 to 20 characters which contain at least one numeric digit, one uppercase, and one lowercase letter.");
    }

    return false;
}
function validateEmail(email) {
    var re = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    return re.test(email);
}


function closeSignUpMenu() {
    setVisible('sign-up', false);
    setVisible('login-bar', true);
}

function setVisible(ID, isVisible) {
    if (isVisible) {
        document.getElementById(ID).style.display = "block";
    } else {
        document.getElementById(ID).style.display = "none";
    }
}
