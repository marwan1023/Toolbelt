package Semaphore;

/*
 This class defines the Parrot Thread
 */

public class Parrot extends Thread
{
	// Declare animal name private variable
	private String name;

	// This function initializes the animal name variable
	public Parrot(String n)
	{
		name = n;
	}

	public void run()
	{

		while(true)
		{
			System.out.println(name + " wants in critical section.");
	        System.out.println(name + " is in critical section.");

	        // Put the thread to sleep
		    Runner.criticalSection();

	        System.out.println(name + " is out of critical section.");

	        // Put the thread to sleep
		    Runner.nonCriticalSection();
	     }
	}
}



