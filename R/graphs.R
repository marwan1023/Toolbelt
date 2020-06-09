x <- c(1,2,3)
y <- c(1,3,8)
plot(x,y)
lmout <- lm (y ~ x)
abline(lmout)
#x11()
lines(c(1,5,2,5),c(3,3))
hist(x)


library(lattice)
a <- 1:10
b <- 1:15
eg <- expand.grid(x=a,y=b)
eg$z <- eg$x^2 + eg$x * eg$y
wireframe(z ~ x+y, eg)
