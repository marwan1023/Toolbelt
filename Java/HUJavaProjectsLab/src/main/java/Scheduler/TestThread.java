package Scheduler;

import java.io.Serializable;

/**
 * TestThread.java
 * 
 * This thread is used to demonstrate how the scheduler operates. This thread
 * runs forever, periodically displaying its name.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999. Copyright 2000 by Greg Gagne, Peter Galvin, Avi
 *          Silberschatz Applied Operating Systems Concepts - John Wiley and
 *          Sons, Inc.
 */

class TestThread extends Thread implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1715789155777466928L;
    private String pid; // The thread id
    private long cpuburst;// The CPU burst per job.
    private int num_cpu_burst;// The number of CPU per job.Therefore, the total
                              // CPUBurst
    private long time_entered; // The time entered in the queue
    private int i = 0, j = 0;
    private int turns = 0;

    // The TestThread Method initializes the pid,CPUBurst, and numOfCPUBurst
    public TestThread(String p, long c, int n) {
        pid = p;
        cpuburst = c;
        num_cpu_burst = n; // timeEntered is set to the current system clock
                           // value
        time_entered = System.currentTimeMillis();// time_enetered is set to the
                                                  // current system clock value
    }

    public void incTurns() {
        turns++;
    }

    public void resetTurns() {
        turns = 1;
    }

    public int getTurns() {
        return turns;
    }

    // The method void consumes the CPU time
    public void run() {

        exec();
    }

    // Method that is called by run() which consumes the CPU time
    public synchronized void exec() {

        for (j = 0; j < num_cpu_burst; j++) {
            for (i = 0; i < cpuburst; i++)
                ;
            System.out.println("Thread[" + pid + "]  :  CPU Burst #" + (j + 1)
                    + " - CPU Time ["
                    + (System.currentTimeMillis() - time_entered) + "]");
        }
    }

    public String getPid() {
        return pid;
    }// return pid

    public long getTimeEntered() {
        return time_entered;
    }// return timeEntered

    // return total CPUBurst
    public synchronized long getCPUBurst() {
        return cpuburst * (num_cpu_burst - j);
    }
}
