package collections.in.java;

import java.util.Iterator;
import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class LinkedHashSetExampleCl {

	@Test
	
/*	// Here you can notice that the elements iterate in insertion order.
	public void insertionOrderFollows() {
		// Creating HashSet and adding elements
		LinkedHashSet<String> set = new LinkedHashSet();
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}*/
	
	
	// Java LinkedHashSet example ignoring duplicate Elements
		public void insertionOrderFollows() {
		  LinkedHashSet<String> al=new LinkedHashSet<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ravi");  
		  al.add("Ajay");  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
		  
		}

}
