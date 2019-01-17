var t = 1;
var obj = { a: 1, b: 2, c: 3 };
for (var key in obj) {
    console.log(key + " = " + obj[key]);
}
var Character = (function () {
    function Character(firstname, lastname) {
        this.fullname = firstname + " " + lastname;
    }
    Character.prototype.greet = function (name) {
        if (name) {
            return "Hello " + name + "! My name is " + this.fullname;
        }
        else {
            return "Hello! My name is " + this.fullname;
        }
    };
    return Character;
}());
var spark = new Character("Mr.", "Marcus Johnson");
var msg = spark.greet();
alert(msg);
msg = spark.greet("Angela Rye");
alert(msg);
var Logger = (function () {
    function Logger() {
    }
    Logger.prototype.log = function (arg) {
        if (typeof console.log === "function") {
            console.log(arg);
        }
        else {
            alert(arg);
        }
    };
    return Logger;
}());
