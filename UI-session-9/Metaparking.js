var currentForm, currentField;
/* event listener for enter key */
window.addEventListener("keypress", function (e) {
    if (e.keyCode == 13) {
        onBlur();
    }
}, false);
var Employee = /** @class */ (function () {
    function Employee(eName, eContact, ePassword, eGender, eEmail) {
        this.employeeName = eName;
        this.employeeContact = eContact;
        this.employeePassword = ePassword;
        this.employeeGender = eGender;
        this.employeeEmail = eEmail;
    }
    Employee.prototype.getEmployeeName = function () {
        return this.employeeName;
    };
    Employee.prototype.getEmployeeContact = function () {
        return this.employeeContact;
    };
    Employee.prototype.getEmployeePassword = function () {
        return this.employeePassword;
    };
    Employee.prototype.getEmployeeGender = function () {
        return this.employeeGender;
    };
    Employee.prototype.getEmployeeEmail = function () {
        return this.employeeGender;
    };
    Employee.prototype.setEmployeeName = function (eName) {
        this.employeeName = eName;
    };
    Employee.prototype.setEmployeeContact = function (eContact) {
        this.employeeContact = eContact;
    };
    Employee.prototype.setEmployeePassword = function (ePassword) {
        this.employeePassword = ePassword;
    };
    Employee.prototype.setEmployeeGender = function (eGender) {
        this.employeeGender = eGender;
    };
    Employee.prototype.setEmployeeEmail = function (eEmail) {
        this.employeeEmail = eEmail;
    };
    return Employee;
}());
// class Vehicles{
//     private vehicleName
//     private vehicleType
//     private  vehicleDescription
//     private employeeGender
//     private employeeEmail
//     constructor(eName :string,eContact:string ,ePassword:String ,eGender :string,eEmail:string){
//         this.employeeName = eName ;
//         this.emaployeeContact = eContact;
//         this.employeePassword = ePassword;
//         this.employeeGender = eGender;
//         this.employeeEmail = eEmail;
//     }
//     setEmployeeName(eName:string) {
//         this.employeeName = eName ;
//     }
//     setEmployeeContact(eContact) {
//         this.emaployeeContact = eContact ;
//     }
//     setEmployeePassword(ePassword) {
//         this.employeePassword = ePassword ;
//     }
//     setEmployeeGender(eGender) {
//         this.employeeGender = eGender ;
//     }
//     setEmployeeEmail(eEmail) {
//         this.employeeEmail = eEmail ;
//     }
// }
/* onclick of add employee
    shows name input */
function registerationForm() {
    document.body.style.backgroundColor = "#7FDBFF";
    Employee.prototype.setEmployeeName(document.getElementById("ename").value);
    document.getElementById("addEmp").style.display = "none";
    document.getElementById("u_Registration").style.display = "block";
    document.getElementById("label").style.display = "block";
    document.getElementById("empName").style.display = "block";
    currentField = "name";
    currentForm = 1;
    var image = document.getElementById("coverImg");
    image.style.display = "none";
}
/*  shows first input of vehcle form */
function vehicleForm() {
    var employeeContact = document.getElementById("ecnumber").value;
    if (!(/^[0-9]{10}$/.test(employeeContact))) {
        document.getElementById("error").innerHTML = "please enter valid contact number";
        return false;
    }
    else {
        document.getElementById("error").innerHTML = " ";
    }
    document.getElementById("empContact").style.display = "none";
    document.getElementById("next1").style.display = "none";
    currentField = "vehName";
    currentForm = 2;
    document.body.style.backgroundColor = "#FF851B";
    var vehicleName = document.getElementById("vehName");
    document.getElementById("u_Registration").style.display = "none";
    document.getElementById("v_Registration").style.display = "block";
    document.getElementById('label').innerHTML = "may I know the name of your vehicle";
    vehicleName.style.display = "block";
}
/* opens up the plan and pricing form */
function planForm() {
    document.getElementById("v_Registration").style.display = "none";
    document.getElementById("p_Registration").style.display = "block";
    document.body.style.backgroundColor = "#DDDDDD";
    document.getElementById("vehDescription").style.display = "none";
    document.getElementById("next2").style.display = "none";
    document.getElementById('label').innerHTML = "choose currency for your plan";
    document.getElementById("currType").style.display = "block";
    currentField = "currency";
    currentForm = 3;
}
/* on submit of plan and pricing form */
function submitForm() {
    var moneypass = '';
    document.getElementById("p_Registration").style.display = "none";
    document.getElementsByName("passtype").forEach(function (item) { if (item.checked) {
        moneypass = item.nextElementSibling.innerText;
    } });
    moneypass = moneypass + " " + document.getElementById("currency").value;
    document.getElementById('label').innerHTML = "Thank you for registering " + Employee.prototype.getEmployeeName() + " Kindly Pay:" + moneypass;
    document.getElementById("plans").style.display = "none";
    document.getElementById("submit").style.display = "none";
}
/* validating password against weak , moderate and strong */
function validatePassword() {
    var employeePassword = document.getElementById("epass").value;
    document.getElementById("epass").style.borderWidth = "thick";
    if (employeePassword.length < 8) {
        document.getElementById("epass").style.borderColor = "red";
        document.getElementById("error").innerHTML = "password should be of min 8 characters";
        return false;
    }
    else if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
        document.getElementById("epass").style.borderColor = "orange";
        document.getElementById("error").innerHTML = "password should contains Uppercase, Lowercase, Numeric";
        return false;
    }
    else {
        document.getElementById("epass").style.borderColor = "green";
        document.getElementById("error").innerHTML = " ";
        return true;
    }
}
/* switch case for employee  form for switching input fields */
function onBlur() {
    if (currentForm == 2) {
        onBlurForm2();
        return false;
    }
    else if (currentForm == 3) {
        onBlurForm3();
        return false;
    }
    var label = document.getElementById("labelText");
    switch (currentField) {
        case "name":
            Employee.prototype.setEmployeeName(document.getElementById("ename").value);
            if (!(/^[A-z ]{2,}$/.test(Employee.prototype.getEmployeeName()))) {
                document.getElementById("error").innerHTML = "please enter valid name";
                return false;
            }
            else {
                document.getElementById("error").innerHTML = " ";
            }
            label.innerHTML = "Hi " + Employee.prototype.getEmployeeName() + " may I know your gender?";
            document.getElementById("empName").style.display = "none";
            document.getElementById("empGender").style.display = "block";
            currentField = "gender";
            break;
        case "gender":
            var employeeGender = document.getElementsByName("egender");
            if (!employeeGender[0].checked && !employeeGender[1].checked) {
                document.getElementById("error").innerHTML = "Please select gender";
                return false;
            }
            else {
                var gender = function (item) { if (document.getElementById('male-radio').value == "on") {
                    item = "Male";
                } };
                Employee.prototype.setEmployeeGender(gender);
                document.getElementById("error").innerHTML = "";
            }
            alert(gender);
            label.innerHTML = " You must be having a email Id";
            document.getElementById("empGender").style.display = "none";
            document.getElementById("empEmail").style.display = "block";
            currentField = "email";
            break;
        case "email":
            var employeeEmail = document.getElementById("eemail").value;
            if (!(/^[A-z]+@[A-z]+\.[A-z]+$/.test(employeeEmail))) {
                document.getElementById("error").innerHTML = "please enter valid email address";
                return false;
            }
            else {
                document.getElementById("error").innerHTML = " ";
            }
            label.innerHTML = "Please choose a password";
            document.getElementById("empEmail").style.display = "none";
            document.getElementById("empPass").style.display = "block";
            document.getElementById("empCnfrmPass").style.display = "block";
            currentField = "password";
            break;
        case "password":
            var employeePassword = document.getElementById("epass").value;
            if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
                document.getElementById("error").innerHTML = "password should contains Uppercase, Lowercase,Special character,Numeric and min 8 characters";
                return false;
            }
            else {
                document.getElementById("error").innerHTML = " ";
            }
            employeePassword = document.getElementById("epass").value;
            var employeeMatchPassword = document.getElementById("ecnfrmpass").value;
            if (employeePassword != employeeMatchPassword) {
                document.getElementById("error").innerHTML = "password doesn't match";
                return false;
            }
            else {
                document.getElementById("error").innerHTML = " ";
            }
            label.innerHTML = "please enter your contact number  ...";
            document.getElementById("empPass").style.display = "none";
            document.getElementById("empCnfrmPass").style.display = "none";
            document.getElementById("empContact").style.display = "block";
            document.getElementById("next1").style.display = "block";
            currentField = "contact";
    }
}
/* switch case for vehicle  form for switching input fields */
function onBlurForm2() {
    var vehicleName = document.getElementById("vname").value;
    ;
    switch (currentField) {
        case "vehName":
            if (vehicleName == "") {
                document.getElementById("error").innerHTML = "required";
                return;
            }
            document.getElementById("error").innerHTML = " ";
            document.getElementById("vehName").style.display = "none";
            document.getElementById('label').innerHTML = " whats the type of " + vehicleName;
            document.getElementById("vehType").style.display = "block";
            currentField = "vehType";
            break;
        case "vehType":
            debugger;
            var vehicleType = document.getElementById("vtype").value;
            if (vehicleType == "") {
                document.getElementById("error").innerHTML = "required";
                return;
            }
            document.getElementById("error").innerHTML = "";
            document.getElementById("vehType").style.display = "none";
            document.getElementById('label').innerHTML = "Mention the number of " + vehicleName;
            document.getElementById("vehNumber").style.display = "block";
            currentField = "vehNumber";
            break;
        case "vehNumber":
            var vehNumber = document.getElementById("vnumber").value;
            if (vehNumber == "") {
                document.getElementById("error").innerHTML = "required";
                return;
            }
            document.getElementById("error").innerHTML = " ";
            document.getElementById("vehNumber").style.display = "none";
            document.getElementById('label').innerHTML = "Tell something about " + vehicleName;
            document.getElementById("vehDescription").style.display = "block";
            document.getElementById("next2").style.display = "block";
            currentField = "vehDescription";
    }
}
/* switch case for plan and pricing  form for switching input fields */
function onBlurForm3() {
    switch (currentField) {
        case "currency":
            var currency = document.getElementById("currency").value;
            var vehicleType = document.getElementById("vtype").value;
            document.getElementById("currType").style.display = "none";
            document.getElementById("label").innerHTML = "choose plan for your " + vehicleType;
            document.getElementById("plans").style.display = "block";
            document.getElementById("submit").style.display = "block";
            currentField = "plan";
            break;
    }
}
/* showing available plans according to vehicle selected */
function showPrice() {
    var curr = document.getElementById("currency").value;
    var plan = document.getElementById("plans").value;
    document.getElementById('plans').style.display = "block";
    var v = document.getElementsByName("vehicleType")[0].children[0].value, daily = 5, monthly = 100, yearly = 500;
    if (v == "Motocycle") {
        daily = 10;
        monthly = 200;
        yearly = 1000;
    }
    else if (v == "Car") {
        daily = 20;
        monthly = 500;
        yearly = 3500;
    }
    switch (curr) {
        case "INR":
            document.getElementById("daily").innerHTML = daily.toFixed(1);
            document.getElementById("monthly").innerHTML = monthly.toFixed(1);
            document.getElementById("yearly").innerHTML = yearly.toFixed(1);
            break;
        case "USD":
            document.getElementById("daily").innerHTML = (daily / 71.74).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 71.74).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 71.74).toFixed(2);
            break;
        case "YEN":
            document.getElementById("daily").innerHTML = (daily / 0.68).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 0.68).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 0.68).toFixed(2);
    }
}
