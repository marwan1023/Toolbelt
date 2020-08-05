package Scheduler;

public class Scheduler extends Thread {
    // Declaration of the queue data members of type CircularList
    private CircularList queue2, queue3, queue1;

    // Declare Variables

    private int level = 1;
    private TestThread currentThread;
    private int order = 0;

    // Initialization on the data members
    public Scheduler() {

        queue2 = new CircularList();
        queue3 = new CircularList();
        queue1 = new CircularList();
    }

    public Scheduler(int quantum) {

        queue2 = new CircularList();
        queue3 = new CircularList();
        queue1 = new CircularList();
    }

    // Enters the testThread instance into the level one queue. The level one
    // queue
    // enforces a preemtive SJF schedule of threads.
    public void addThread(TestThread t) {
        TestThread x;
        
        if (queue1.size() != 0) {
            if (t.getCPUBurst() < currentThread.getCPUBurst()) {
                currentThread.setPriority(2);
                t.setPriority(4);
                System.out.println("* * * Context Switch * * * ");
                currentThread = t;
            } else {
                for (int i = 0; i < queue1.getSize(); i++) {
                    x = (TestThread) queue1.elementAt(i);
                    if (t.getCPUBurst() < x.getCPUBurst()) {
                        queue1.insertElementAt(t, i--);
                    }
                }
                queue1.insertElementAt(t, (queue1.getSize() + 1));
            }
        }
        queue1.addItem(t);
    }

    // Based on the levelof the queue, set the current to sleep for
    // 800, 1000, or 4000 msec

    private void schedulerSleep() {

        try {
            if (level == 1)
                Thread.sleep(80);
            if (level == 2)
                Thread.sleep(100);
            if (level == 3)
                Thread.sleep(400);
        } catch (InterruptedException e) {
        }
    }

    // This method enables modifications to promote threads to a higher
    // level queue based on the residency rules
    public void run() {

        // set the priority of the scheduler to the highest priority
        this.setPriority(6);

        while (order < 6) {

            try {
                if (queue1.getSize() > 10) {
                    level = 1;
                    currentThread = (TestThread) queue1.getNext();
                    currentThread.incTurns();
                    order++;
                    if (currentThread.getTurns() > 2) {
                        queue2.addItem(currentThread);
                        queue1.removeElement(currentThread);
                    }
                }
                if ((queue2.getSize() > 0) || (queue1.getSize() == 0)) {
                    level = 2;
                    currentThread = (TestThread) queue2.getNext();
                    if (currentThread.getTurns() > 4) {
                        queue3.addItem(currentThread);
                        queue2.removeElement(currentThread);
                    }
                }
                if ((queue3.getSize() > 0) || (queue2.getSize() == 0)
                        && (queue1.getSize() == 0)) {
                    currentThread.resetTurns();
                    level = 3;
                    currentThread = (TestThread) queue2.getNext();
                    currentThread.incTurns();
                    // order++;
                }
                if ((currentThread != null) && (currentThread.isAlive())) {

                    currentThread.setPriority(4);
                    schedulerSleep();
                    System.out.println("* * * Context Switch * * * ");
                    System.out.println("   " + level + "        " + order
                            + "     " + currentThread.getTurns() + "     "
                            + currentThread.getPid() + "      "
                            + currentThread.getCPUBurst() + "        "
                            + System.currentTimeMillis());
                    currentThread.setPriority(2);

                }

                // System.out.println("   "+level+"        "+order+"     "+currentThread.getTurns()+"     "+currentThread.getPid()+"      "+currentThread.getCPUBurst()+"        "+
                // System.currentTimeMillis());

            } catch (NullPointerException e) {
            }
        }
    }
}
