package Semaphore;

/*
 This is the class that defines the Dog Thread
 */



public class Dog extends Thread
{
	// Declare private variables that indicate the Semaphores, the animal names, and the counter
	private Semaphore catdog;
	private Semaphore dogmutex;
	private String name;
	private int count;

	// This function will initialize the private variables
	public Dog(String n,Semaphore a, Semaphore b)
	{
		name = n;
		catdog = a;
		dogmutex = b;
		count=0;
	}


	// Run function for the Cat Thread
	public void run()
	{

		while(true)
		{
			// Dog critical section entrance request
			dogmutex.P();

			// Decrease counter
			++count;

			System.out.println(name + " wants in critical section.");


			// The following if statement will ensure the cat
			// is not in the critical section if true
			if(count==1)
			{
				catdog.P();
			}

			System.out.println(name + " is in of critical section.");

			// Put thread to sleep
			Runner.criticalSection();

			// This statement ensures the dog is not in the critical section
			dogmutex.V();
			dogmutex.P();

			System.out.println(name + " is out of critical section.");

			// Put thread to sleep
			Runner.nonCriticalSection();

			// Decrease counter
			--count;

			// The cat is in the critical section if true
			if(count==0)
			{
				catdog.V();
			}

			// Dog leave request
			dogmutex.V();
			// The cat leaves the critical section
			catdog.V();

			System.out.println(name + " is out of critical section.");

			// Put the thread to sleep
			Runner.nonCriticalSection();
	     }
	}
}



