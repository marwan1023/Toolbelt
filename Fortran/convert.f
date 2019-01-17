program convert
implicit none
integer :: pounds,pence,total
character :: name*10
print *, 'What is your name?'
read *, name
print *, 'Hello ',name
print *, 'Enter numbers of pounds and pence'
read *, pounds,pence
total = 100 * pounds + pence
print *, 'Total money in pence is: ', total
end program
