program readdatea
implicit none
real :: x,y,z
open(10,file='mydata.txt')
read(10,*) x,y,z
print *, x,y,z
end program
