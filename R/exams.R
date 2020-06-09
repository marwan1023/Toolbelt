examgrades <- read.table("/Users/johnson_marcus/git/Toolbelt/R/grades.txt", header=FALSE)
head(examgrades)
lma <- lm(examgrades[,2] ~ examgrades[,1])
attributes(lma)
lma
summary(lma)
