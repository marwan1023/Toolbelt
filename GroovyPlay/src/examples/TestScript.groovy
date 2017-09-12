package examples

def book = new BookBean()

book.setTitle('New Title')
book.setYear(1979)

assert book.getTitle() == "New Title"
assert book.getYear() == 1979

def result = (1==1) ? 'ok' : 'failed'
assert result == 'ok'
result = 'hello' ? 10 : ['x']
assert result == 10

def x = 0

while (x < 10)
{
    x++
}

def vwc = new VendorWithCtor("hello", "world")

println(vwc.getName())

def command = "start"

switch (command)
{
    case "start":
        println("Starting...")
        break
    case "stop":
        println("Stopping...")
        break
    default:
        println("no command")
        break
}

String str = "12345"
switch (str) {
   case ~/^[A-Za-z]+$/: println "Alphabet only"; break;
   case ~/^[0-9]+$/: println "Numeric only"; break;
   default: println "Others";
}

def sout = new StringBuilder()
def serr = new StringBuilder()
def testCommand = "whoami".execute()
testCommand.consumeProcessOutput(sout, serr)
testCommand.waitForOrKill(1000)
println(sout)

try {
    def arr = new int[3];
    arr[5] = 5;
 } catch(Exception ex) {
    println("Catching the exception");
 }







