x <- c(5, 10, 25, 600)
x <- c(x[1:2],200,x[3:4])
length(x)
y <- c(24,16,1000,19,87)
z <- x + y
z[1:3]
seq(from=5,to=20,by=2)
all(z > 100)
any(z > 100)
z[z < 50]
ifelse(z > 30, z+5, z -5)
