package Semaphore;

/*
 This is the class that defines the Elephant Thread
 */



public class Elephant extends Thread
{


	// Declare private variables that indicate the Semaphores, the animal names, and the counter
	private Semaphore elephmouse;
	private Semaphore elephmutex;
	private String name;
	private int count;

	// This function will initialize the private variables
	public Elephant(String n, Semaphore a,Semaphore b)
	{
		name = n;
		elephmouse = a;
		elephmutex = b;
		count = 0;
	}

	// Run function for the Elephant Thread
	public void run()
	{
		while(true)
		{
			// Elephant critical section entrance request
			elephmutex.P();

			// Increase the counter
			++count;
			System.out.println(name + " wants in critical section.");

			// The following if statement will ensure the mouse is not
			// in the critical section if true
			if(count==1)
			{
				elephmouse.P();
			}

			System.out.println(name + " is in critical section.");

			// Put thread to sleep
			Runner.criticalSection();

			// Elephant leaves the critical section
			elephmutex.V();
			elephmutex.P();

			System.out.println(name + " is out of critical section.");

			// Put the thread to sleep
			Runner.nonCriticalSection();

			// Decrease the counter
			--count;

			// The mouse is in the critical section if true
			if(count==0)
			{
				elephmouse.V();
			}
			// Leave request
			elephmutex.V();
			// The mouse is out of the critical section
			elephmouse.V();

			System.out.println(name + " is out of critical section.");

			// Put the thread to sleep
			Runner.nonCriticalSection();

		}
	}
}



