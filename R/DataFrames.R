kids <- c("jack","jill")
ages <- c(12,10)
d <- data.frame(kids,ages,stringsAsFactors=FALSE)
d
str(d)
d <- rbind(d,list("Laura",19))
weight <- c(100,85,115)
cbind(d,weight)

