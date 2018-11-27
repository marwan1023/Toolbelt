program readdatea
implicit none
integer :: num,i
open(10,file='mydata.txt')
do i=0,6
  read(10,*) num
  if (mod(num,2) >0) then
    print *, num
  else
    print *, 'Even'
  end if 
end do
end program
