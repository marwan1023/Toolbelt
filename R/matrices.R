y <- matrix(c(1,2,3,4), nrow = 2, ncol=2)
y

y[,2]
m <- matrix(c(1,2,3,4,5,6), nrow=2,byrow=T)
m

z = 4*y
z+y
m[,2:3]

install.packages(pixmap)
library(pixmap)
picR <- read.pnm("/Users/johnson_marcus/Downloads/logo.ppm")
picR
plot(picR)
m[m[,3] > 5]
apply(m, 2, mean)
