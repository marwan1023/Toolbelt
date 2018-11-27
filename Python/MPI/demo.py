from mpi4py import MPI

# MPI variables for communication, rank, size, and name of the node
comm = MPI.COMM_WORLD
rank = comm.Get_rank()
size = comm.Get_size()
name = MPI.Get_processor_name()

total_requests = 10000 
process1=0
process2=0
process3=0

# This is the master node.
if rank == 0:
    request = 0
    process = 1

    # Send the first batch of processes to the nodes.
    while process < size and request < total_requests:
        comm.send(request, dest=process, tag=1)
        print "Sending request",request,"to process",process
        request += 1
        process += 1

    # Wait for the data to come back
    received_processes = 0
    while received_processes < total_requests:
        process = comm.recv(source=MPI.ANY_SOURCE, tag=1)
        print "Received data from process", process 
        if (process == 1):
	    process1 += 1
	elif (process == 2):
            process2 += 1
	elif (process == 3):
            process3 +=1
        received_processes += 1

        if request < total_requests:
            comm.send(request, dest=process, tag=1)
            print "Sending request",request,"to process", process 
            request += 1

    # Send the shutdown signal
    for process in range(1,size):
        comm.send(-1, dest=process, tag=1)
    print "\nProcess 1 Message Total: ",process1
    print "Process 2 Message Total: ",process2
    print "Process 3 Message Total: ",process3
    print "End"

# These are the slave nodes, where rank > 0. They receive the request from the master node and simply send a response back 
else:
    while True:
        start = comm.recv(source=0, tag=1)
        if start == -1: break
        comm.send(rank, dest=0, tag=1)

