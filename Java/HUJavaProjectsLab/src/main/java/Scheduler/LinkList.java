package Scheduler;


import java.util.ArrayList;

public class LinkList {	
	private ArrayList<Object> List;
	private int index;
	public LinkList()
	{		List = new ArrayList<Object>();		index = 0;	}	
   
   /**
    * this method returns the next element in the list.
    * @return Object
    */
	
   
	public Object getNext()
	{		Object nextElement = null;		//int lastElement;		if (!List.isEmpty())
		{			if (index == List.size())				index = 0;
						nextElement = List.get(index);			++index;		}		return nextElement;	}
   
   /**
    * this method adds an item to the list
    * @return void
    */
	public void addItem(Object t)
	{		List.add(t);      	}}
