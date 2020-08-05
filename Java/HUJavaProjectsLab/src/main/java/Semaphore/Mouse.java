package Semaphore;

/*
 This is the class that defines the Mouse Thread
 */



public class Mouse extends Thread
{

	// Declare private variables that indicate the Semaphores, the animal names, and the counter
	private Semaphore elephmouse;
	private Semaphore catmouse;
	private Semaphore mousemutex;
	private String name;
	private int count;

	// This function will initialize the private variables
	public Mouse(String n, Semaphore dj, Semaphore tj,Semaphore m)
	{
		name = n;
		elephmouse = dj;
		catmouse = tj;
		mousemutex = m;
		count=0;
	}
	// Run function for the Mouse Thread
	public void run()
	{

		while(true)
		{
			// Mouse critical section entrance request
			mousemutex.P();

			// Increase the counter
			++ count;

			System.out.println(name + " wants in critical section.");

			// The following if statement will ensure the elephant and the cat
			// is not in the critical section if true
			if(count==1)
			{
				elephmouse.P();
				catmouse.P();
			}

			System.out.println(name + " is in of critical section.");

			// Put thread to sleep
			Runner.criticalSection();

			// Mouse leaves the critical section
			mousemutex.V();
			mousemutex.P();
			System.out.println(name + " is out of critical section.");

			// Puts the thread to sleep
			Runner.nonCriticalSection();

			// Decrease the counter
			--count;

			// The cat and the elephant are in the critical section if true
			if(count==0)
			{
				elephmouse.V();
				catmouse.V();
			}

			// Leave request
			mousemutex.V();
			// Elephant leaves the critical section
			elephmouse.V();

			System.out.println(name + " is out of critical section.");

			// The cat leaves the critical section
			catmouse.V();

			System.out.println(name + " is out of critical section.");

			// Puts the thread to sleep
			Runner.nonCriticalSection();

	     }
	}
}



