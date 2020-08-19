package Semaphore;

/**
 * Runner.java
 *
 * This class contains static methods that simulate critical
 * and non-critical sections. Simulations are done by sleeping
 * a random period of time between 0 and 3 seconds.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

public class Runner
{
   public static void criticalSection() {
      try {
            
			double time = Math.random() * 3000;
            Thread.sleep( Double.valueOf(time).longValue() );
      }  
      catch (InterruptedException e) { }
   }

   public static void nonCriticalSection() {
      try {
          double time = Math.random() * 3000;
          Thread.sleep( Double.valueOf(time).longValue() );
      }  
      catch (InterruptedException e) { }
   }
}