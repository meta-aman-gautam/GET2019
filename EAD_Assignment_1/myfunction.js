var i=0, type ,id ,c1 ,v,string ,pass = "",name,dummy_v;
function getId(){
    return ++i;
}

function register(){

    name = document.getElementById("name").value;
    document.getElementById("register").innerHTML = "<h1>Your in Registration ID is : " + getId()+"</h1>";
    document.getElementById("employeeid").value = this.i; 
    document.getElementsByClassName("vehicledetailsCSS")[0].style.display = 'block';
}

function checkForms(){

    var fullName = document.forms["registration"]["name"].value ;
    var email = document.forms["registration"]["email"].value ;
    var password = document.forms["registration"]["psswd"].value ;
    var confirmpass= document.forms["registration"]["confirmPsswd"].value ;
    var contact =  document.forms["registration"]["mobile"].value ;
    var pass =  document.forms["registration"]["psswd"].value ;

    var phonePattern = /^\d{10}$/;
    var fullNamePattern = /^[A-z ]+[A-z ]+$/ ;
    var emailpattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-z]{2,4})+$/ ;
    var passPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
    var count=true;
    if(!fullName.match(fullNamePattern)){
        document.getElementById("fullName").innerText = "Invalid Name";
        count = false;
    }
    else{
        document.getElementById("fullName").innerText = "";
    }
    
    if(!contact.match(phonePattern)){
        alert("Phone no should be no less than 10 digits");
        document.getElementById("mobile").innerText= "Invalid Mobile no.";
        count= false;
    }
    else{
        document.getElementById("mobile").innerText="";
    }


    if(!email.match(emailpattern)){
        alert("Email format should be Aman@12345");
        document.getElementById("email").innerHTML = "Invalid Email";
        count =false;
    }
    else{
        document.getElementById("email").innerHTML = "";
    }
    if(!pass.match(passPattern)){
        document.getElementById("psswd").innerHTML ="Invalid Password";
        alert("Password should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8")
        count =false;
    }
    else{
        document.getElementById("psswd").innerHTML = "";
    }


    if(password != confirmpass){
        document.getElementById("confirmPsswd").innerText ="Password does not match";
        count =false;
    }
    else{
        document.getElementById("confirmPsswd").innerText = "";
    }
    
    if(count==true){
        register();
    }
}

function currencycheck(){
    v = [5,100,500 ,10,200,1000,20,500,3500] ;
    dummy_v=[];
    c2=" USD";

    if(document.getElementById("currency").value==="YEN"){
       for(var i=0;i<v.length;i++){
           v[i] = v[i]*1.47380 ;
        }
        c1=" YEN";
        for(var i=0;i<v.length;i++){
            dummy_v[i] = v[i]*0.0094628 ;
        }
    }
    else if(document.getElementById("currency").value==="USD"){
        for(var i=0;i<v.length;i++){
            v[i] = v[i]*0.0138859 ;
            dummy_v[i]=v[i];
        }
        c1 =" USD";
    }
    else if(document.getElementById("currency").value==="INR"){
        c1 =" INR";
        for(var i=0;i<v.length;i++){
            dummy_v[i] = v[i]*0.0138859 ;
        }
    }
}

function vehicleDetails(){
    type = document.getElementById("type").value ;
    id = document.getElementById("employeeid").value ;
    currencycheck();

    switch(type){
        case "BICYCLE":
            document.getElementById("DAILY").innerHTML = v[0]+" "+c1;
            document.getElementById("MONTHLY").innerHTML = v[1]+" "+c1;
            document.getElementById("YEARLY").innerHTML = v[2]+" "+c1;
            daily = dummy_v[0]+" "+c2;
            monthly = dummy_v[1]+" "+c2;
            yearly = dummy_v[2]+" "+c2;
            break;

        case "MOTOR CYCLE":
            document.getElementById("DAILY").innerHTML = v[3]+" "+c1;
            document.getElementById("MONTHLY").innerHTML = v[4]+" "+c1;
            document.getElementById("YEARLY").innerHTML = v[5]+" "+c1;
            daily = dummy_v[3]+" "+c2;
            monthly = dummy_v[4]+" "+c2;
            yearly = dummy_v[5]+" "+c2;
            break;  
        
        case "CAR":
            document.getElementById("DAILY").innerHTML = v[6]+" "+c1;
            document.getElementById("MONTHLY").innerHTML = v[7]+" "+c1;
            document.getElementById("YEARLY").innerHTML = v[8]+" "+c1;
            daily = dummy_v[6]+" "+c2;
            monthly = dummy_v[7]+" "+c2;
            yearly = dummy_v[8]+" "+c2;
            break;    
        default:
            alert("NO PASS GENERATED")
            break; 
            
        
    }

}

function showPass(string){
    pass =pass+ "ID - "+id+"\n"+"<br>";
    pass =pass+ "Employee Name-"+name+"\n"+"<br>"
    pass =pass+ "Vehicle Type - "+type+"\n"+"<br>";
    pass =pass+ "Vehicle No - "+document.getElementById("vehicleno").value+"\n"+"<br>";
  
    switch(string){
        case "DAILY":
            pass =pass+"DAILY PASS  - " +daily;
            break;
        case "MONTHLY":
            pass =pass+"MONTHLY PASS - " +monthly;
            break; 
        case "YEARLY":
            pass =pass+"YEARLY PASS - " +yearly;
            break;       
    }
    document.getElementById("currencydiv").innerHTML = "<h2>YOUR PASS HAS BEEN GENERATED"+"<br><br>"+pass+"</h2>" ;
    alert("YOUR PASS HAS BEEN GENERATED"+"\n");
}

function collapse(){
    var col1 = document.getElementsByClassName("collapsible");
    var i;
    for(i=0;i<col1.length;i++){
        col1[i].addEventListener("click" , function(){
            this.classList.toggle("active");
            var content = this.nextElementSibling;
            if(content.style.display === "block"){
                content.style.display="none";
            }
            else{
                content.style.display="block";
            }
        });
    }
}