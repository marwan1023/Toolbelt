package Scheduler;
/**


 * CircularList.java
 *
 * This class implements a circular list using the Vector class
 * note that elements in a vector with n elements are numbered 0 .. (n-1)
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999.
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class CircularList extends Vector<Object> {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private List<TestThread> List;
    private int index;

    public CircularList() {
        List = new ArrayList<TestThread>(10);
        index = 0;
    }

    public Object getNext() {
        Object nextElement = null;

        if (!List.isEmpty()) {
            if (index == List.size())
                index = 0;
            nextElement = List.get(index);
            ++index;
        }
        return nextElement;
    }

    public void addItem(TestThread t) {
        List.add(t);
    }

    public int getSize() {
        return List.size();
    }

    public void print() {
        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i));
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}
