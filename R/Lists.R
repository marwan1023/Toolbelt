j <- list(name="Joe", salary=50000, union=T)
j$name
j$union
j[2:3]
j[2]
salary <- j[2]
j$lastname <- "Johnson"
#j$salary <- NULL

length(j)
ulj <- unlist(j)
ulj
class(j)

b <- list(u=5, v=12)
c <- list(w=13)
d <- list(b,c)
d
class(d)
