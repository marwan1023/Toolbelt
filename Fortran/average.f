program avg
implicit none
real ,dimension(5) :: x
real :: average,sum
integer :: i
print *, 'Enter 5 numbers'
sum = 0.0
do i=1,5
  read *, x(i)
  sum = sum + x (i)
end do
average=sum/5
print *, 'The average is ', average
print *, 'Numbers are '
print *, x
end program
