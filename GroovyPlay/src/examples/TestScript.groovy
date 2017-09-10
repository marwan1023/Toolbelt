package examples

//Book book = new Book("New Title")
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

print(vwc.getName())



