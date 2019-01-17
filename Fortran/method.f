program method
implicit none
integer :: a,b
a = 10
b = 2
call calculate(a,b)
end program

subroutine calculate(a,b)
implicit none
integer :: a,b
print *, a+b
print *, a-b
print *, a*b
print *, a/b
end subroutine calculate
