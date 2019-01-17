program trig
implicit none
real :: a,pi
print *, 'Enter an angle between 0 and 90'
read *, a
if (a >= 0 .and. a <= 90) then
   pi=4.0*atan(1.0)
   print *, 'The sine of ', a,' is ',sin(a*pi/180)
else
   print *, 'You have entered an invalid angle.'
endif
end program
