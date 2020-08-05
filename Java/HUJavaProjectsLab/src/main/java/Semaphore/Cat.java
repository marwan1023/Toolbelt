package Semaphore;

/*
 This is the class that defines the Cat Thread
 */



public class Cat extends Thread
{

	// Declare private variables that indicate the Semaphores, the animal names, and the counter
	private Semaphore catdog;
	private Semaphore catmouse;
	private Semaphore catmutex;
	private String name;
	private int count;

	// This function will initialize the private variables
	public Cat(String n, Semaphore a, Semaphore b, Semaphore c)
	{
		name = n;
		catdog = a;
		catmouse = b;
		catmutex = c;
		count=0;
	}

	// Run function for the Cat Thread
	public void run()
	{

		while(true)
		{
			// Cat critical section entrance request
			catmutex.P();

			// increment counter
			++count;

			System.out.println(name + " wants in critical section.");

			// The following if statement will ensure the dog and the cat
			// is not in the critical section if true
			if(count==1)
			{
				catdog.P();
				catmouse.P();
			}

			System.out.println(name + " is in critical section.");

			// Put thread to sleep
			Runner.criticalSection();

			// The following statement will take the cat out of the critical section
			catmutex.V();
			catmutex.P();
			System.out.println(name + " is out of critical section.");

			// Put thread to sleep
			Runner.nonCriticalSection();

			// decrease counter
			--count;

			// The dog and mouse are in the critical section if true
			if(count==0)
			{
				catdog.V();
				catmouse.V();
			}
			// Cat leave request
			catmutex.V();

			// These statements will ensure both the dog and the mouse are out of the
			// critical section
			catdog.V();
			System.out.println(name + " is out of critical section.");
			catmouse.V();
			System.out.println(name + " is out of critical section.");

			// Put thread to sleep
			Runner.nonCriticalSection();


	     }
	}
}



