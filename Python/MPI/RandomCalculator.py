#!/usr/bin/env python

from mpi4py import MPI 
import random, time 

# MPI variables for communication, rank, size, and name of the node
comm = MPI.COMM_WORLD
rank = comm.Get_rank()
size = comm.Get_size()
name = MPI.Get_processor_name()

VALUE_ONE=0
VALUE_TWO=0


# This is the master node.
if rank == 0:
    RESULT = 0
    process = 1

# Send the first batch of processes to the nodes.
    while process < size:
        comm.send(RESULT, dest=process, tag=1)
        print "Sending result",RESULT,"to process",process
        process += 1

# Wait for the data to come back
    while RESULT < 10000:
        process = comm.recv(source=MPI.ANY_SOURCE, tag=1)
        print "Received data from process", process
        if (process == 1):
           VALUE_ONE = random.randint(10,20)
           VALUE_TWO = random.randint(10,30) 
           print "Process ", process," Product: ", VALUE_ONE, "*", VALUE_TWO 
           RESULT += VALUE_ONE * VALUE_TWO 
        elif (process == 2):
           VALUE_ONE = random.randint(20,30)
           VALUE_TWO = random.randint(5,10)
           print "Process ", process," Product: ", VALUE_ONE, "*", VALUE_TWO
           RESULT += VALUE_ONE * VALUE_TWO
        elif (process == 3):
           VALUE_ONE = random.randint(30,40)
           VALUE_TWO = random.randint(2,8)
           print "Process ", process," Product: ", VALUE_ONE, "*", VALUE_TWO
           RESULT += VALUE_ONE * VALUE_TWO

        if RESULT < 10000:
            comm.send(RESULT, dest=process, tag=1)
            print "Sending result",RESULT,"to process", process

# Send the shutdown signal
    for process in range(1,size):
        comm.send(-1, dest=process, tag=1)
    print "\nRESULT: ",RESULT
    print "End"

else:
    while True:
        start = comm.recv(source=0, tag=1)
        if start == -1: break
        comm.send(rank, dest=0, tag=1)

