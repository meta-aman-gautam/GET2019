
function empFormValidation() {
    var flag = true;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;
    var number = document.getElementById("number").value;


    //Name Validation
    if (name.length < 2) {
        var message = "length of name should be 2 character";
        document.getElementById("ename").innerHTML = message;
        flag = false;
    } else if (!(/^[a-zA-Z ]+$/.test(name))) {
        var message = "name must be in alphabet";
        document.getElementById("ename").innerHTML = message;
        flag = false;
    } else {
        document.getElementById("ename").innerHTML = "";
    }

    // Email Validation
    if (!(/\S+@\S+\.\S+/.test(email))) {
        var message = "invalid email address";
        document.getElementById("eemail").innerHTML = message;
        flag = false;
    }
    else {
        document.getElementById("eemail").innerHTML = "";
    }

    //Password Validation
    if (password.length < 8) {
        var message = "password length should be 8 ";
        document.getElementById("epassword").innerHTML = message;
        flag = false;
    } else if (!(/^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]+$/.test(password))) {
        var message = "password should be at least One Upper and One Lower case and one digit";
        document.getElementById("epassword").innerHTML = message;
        flag = false;
    }
    else {
        document.getElementById("epassword").innerHTML = "";
    }
    //Confirm Password Validation
    if (password != confirm_password) {
        var message = "Password not matching";
        document.getElementById("econfirm_password").innerHTML = message;
        flag = false;
    }
    else {
        document.getElementById("econfirm_password").innerHTML = "";
    }

    //Phone Number Validation
    if (number.length < 8) {
        var message = "phone number length should be greater than 8";
        document.getElementById("enumber").innerHTML = message;
        flag = false;

    } else if (!(/^[0-9]+$/.test(number))) {
        var message = "phone number must contain only numeric value";
        document.getElementById("enumber").innerHTML = message;
        flag = false;

    }
    else {
        document.getElementById("enumber").innerHTML = "";
    }

    return flag;
}