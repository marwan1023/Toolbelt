var t: number = 1;

var obj: any = {a:1, b:2, c:3};
for (var key in obj) {
    console.log(key + " = " + obj[key]); 
}

class Character {
 
    fullname : string;
    constructor(firstname : string, lastname : string) {
      this.fullname = firstname + " " + lastname;
    }
    
    greet(name? : string) {
        if (name)
        {
            return "Hello " + name + "! My name is " + this.fullname;
        }
        else
        {
            return "Hello! My name is " + this.fullname;
        }
    }
 }

var spark = new Character("Marcus","Johnson");
var msg = spark.greet();
alert(msg);
msg = spark.greet("Angela Rye")
alert(msg);

interface LoggerInterface{
    log(arg : any) : void;
}

class Logger implements LoggerInterface {
    log(arg) {
        if(typeof console.log === "function"){
            console.log(arg)
         }
        else {
            alert(arg);
        }
    }
}

