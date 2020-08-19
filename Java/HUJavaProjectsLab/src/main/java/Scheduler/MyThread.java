package Scheduler;

class MyThread extends TestThread {

    /**
     * 
     */
    private static final long serialVersionUID = 5930014861331957415L;
    // Declare Variables
    private int turns = 0;

    public MyThread(TestThread t) {
        super(t.getPid(), t.getCPUBurst(), 1);
    }

    // Function that increments number of turns
    public void incTurns() {
        turns++;
    }

    // Function that resets turns
    public void resetTurns() {
        turns = 0;
    }

    // Function that gets number of turns
    public int getTurns() {
        return turns;
    }
}
