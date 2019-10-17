

String.prototype.repeatify = function(no_of_times){
    var outputString ="";
    while(no_of_times!=0){
        outputString+= this;
        no_of_times --;
    }
    
    return outputString ;
} 

