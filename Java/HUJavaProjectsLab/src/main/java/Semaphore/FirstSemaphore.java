package Semaphore;

/*
	Marcus Johnson
	129976
	Operating Systems
	Program #2
  */

import java.io.*;
import java.util.*;

public class FirstSemaphore
{

	public static void main(String args[])
	{

		// Declaration of variables that include the animal names
		// and the Thread choice integer
		BufferedReader in = null;
		String line;
		String name;
		StringTokenizer tok;
		int choice;

		// Semaphore instances both singular and ones showing relationships
		// Relationships are below
		Semaphore catmouse = new Semaphore(1);
		Semaphore catdog = new Semaphore(1);
		Semaphore elephmouse = new Semaphore(1);

		// Singular instances are below
		Semaphore catmutex=new Semaphore(1);
		Semaphore dogmutex=new Semaphore(1);
		Semaphore mousemutex=new Semaphore(1);
		Semaphore elephmutex=new Semaphore(1);


		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		try
		{
		   try {
            in = new BufferedReader(new InputStreamReader(
                       new FileInputStream("SEMAPHORE.dat"), "UTF8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		}
		catch(FileNotFoundException e)   // check if file is found
		{
		    System.out.println(e.toString());
		    System.exit(1);
		}

		try
		{
		    if (in != null)
		    {
		        while((line = in.readLine()) != null)  // read a line until EOF
	            {
	                tok = new StringTokenizer(line, " ");
	                name = tok.nextToken().toString();
	                choice = Integer.parseInt(tok.nextToken());

	                // Switch statment uses to check which thread will be called
	                switch (choice)
	                {
	                    case 1:
	                        Dog mydog = new Dog(name,catdog,dogmutex);
	                        // starts the thread , calls the run method in Dog
	                        mydog.start();
	                        break;

	                    case 2:
	                        Cat mycat = new Cat(name,catdog,catmouse,catmutex);
	                        // starts the thread , calls the run method in Cat
	                        mycat.start();
	                        break;

	                    case 3:
	                        Mouse mymouse = new Mouse(name,catmouse,elephmouse,mousemutex);
	                        // starts the thread , calls the run method in Mouse
	                        mymouse.start();
	                        break;

	                    case 4:
	                        Elephant myelephant = new Elephant(name,elephmouse,elephmutex);
	                        // starts the thread , calls the run method in Elephant
	                        myelephant.start();
	                        break;

	                    case 5:
	                        Parrot myparrot = new Parrot(name);
	                        // starts the thread , calls the run method in Parrot
	                        myparrot.start();
	                        break;

	                    default:
	                        break;

	                }

	            }
		    }

			System.runFinalization();  // need this to run your finalizer
		}
		catch(IOException e)
		{
			   System.out.println("Error:  " + e.toString());
		}
	}
}

