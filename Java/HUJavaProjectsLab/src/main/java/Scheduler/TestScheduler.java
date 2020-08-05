package Scheduler;

/*Marcus Johnson
  Operating Systems
  Programming Assignment 1
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class TestScheduler
{

   public static void main(String args[])
   {
		/**
		* This must run at the highest priority to ensure that
		* it can create the scheduler and the example threads.
		* If it did not run at the highest priority, it is possible
		* that the scheduler could preempt this and not allow it to
		* create the example threads.
		*/


		// Declare Variables
		BufferedReader in = null;
	    String line;
	    String pid;
	    long CPUBurst;
	    int numOfCPUBurst;


		// This statement sets thread to highest priority
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		// Attempts to read in the data file
	    try
	    {
			try {
                in = new BufferedReader(new InputStreamReader(
                        new FileInputStream("SCHEDULER.DAT"), "UTF8"));
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
			System.out.println("QUEUELEV  ORDER  TURNS   PID      CPUBURST      CPUTIME    ");
			
			if (in != null)
		    {
		        while((line = in.readLine()) != null)  // read a line until EOF
	            {
		            String[] tokens = line.split(" ");
	                pid=tokens[0];
	                CPUBurst=Long.parseLong(tokens[1]);
	                numOfCPUBurst=Integer.parseInt(tokens[2]);

	                Scheduler CPUScheduler = new Scheduler();
	                CPUScheduler.start();
	                TestThread tt = new TestThread(pid,CPUBurst,numOfCPUBurst);
	                tt.setPriority(2);
	                tt.start();
	                CPUScheduler.addThread(tt);
	                
	                

	            }
		    }
			
		
			
			System.runFinalization(); // need this to run your finalizer
		}
		catch(IOException e)
		{
			   System.out.println("Error:  " + e.toString());
		}
   }
}

