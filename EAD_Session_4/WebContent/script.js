function showPrice() {

    currency = document.getElementById("currency").value;
    plan = document.getElementById("plans").value;

    plans.style.display = "block";
    var v = vehicleType;
    var daily = 5;
    var monthly = 100;
    var yearly = 500;

    if (v == "Motocycle") {
        daily = 10;
        monthly = 200;
        yearly = 1000;
    } else if (v == "Car") {
        daily = 20;
        monthly = 500;
        yearly = 3500;
    }

    var cur = currency;
    switch (cur) {
        case "INR":
            document.getElementById("daily").innerHTML = daily;
            document.getElementById("monthly").innerHTML = monthly;
            document.getElementById("yearly").innerHTML = yearly;
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
            break;
    }
}
function setPricing() {
    document.getElementById("pricing").innerHTML = "<p style='font-size:180%'>Plan choosen successfully</p>"
}