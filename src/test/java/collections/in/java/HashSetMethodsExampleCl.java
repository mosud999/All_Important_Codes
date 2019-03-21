package collections.in.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.testng.annotations.Test;

public class HashSetMethodsExampleCl {
	
	@Test
	
/*	public void hashSetExamle()
	{
		//Creating HashSet and adding elements  
	    HashSet<String> set=new HashSet();  
	           set.add("One");    
	           set.add("Two");    
	           set.add("Three");   
	           set.add("Four");  
	           set.add("Five");  
	           Iterator<String> i=set.iterator();  //Notice, the elements iterate in an unordered collection;
	           while(i.hasNext())  
	           {  
	           System.out.println(i.next());  
	           }  
	}*/
	
	/*// we see that HashSet doesn't allow duplicate elements.
	public void igonringDuplicateElements()
	{
		HashSet<String> s1=new HashSet<String>();
		s1.add("love");
		s1.add("lime");
		s1.add("love");
		
		Iterator i1=s1.iterator();
		
		while(i1.hasNext())
		{
			
			System.out.println(i1.next());
		}
			
	}*/
	
/*	// Here, we see different ways to remove an element;
	public void removeElement()
	{
		HashSet<String> set=new HashSet<String>();  
        set.add("Ravi");  
        set.add("Vijay");  
        set.add("Arun");  
        set.add("Sumit");  
        System.out.println("An initial list of elements: "+set);  
        //Removing specific element from HashSet  
        set.remove("Ravi");  
        System.out.println("After invoking remove(object) method: "+set);  
        HashSet<String> set1=new HashSet<String>();  
        set1.add("Ajay");  
        set1.add("Gaurav");  
        set.addAll(set1);  
        System.out.println("Updated List: "+set);  
        //Removing all the new elements from HashSet  
        set.removeAll(set1);  
        System.out.println("After invoking removeAll() method: "+set);      
         
	}*/
	
	
	// Java HashSet from another Collection
	public void hashSet_from_another_Collection()
	{
		 ArrayList<String> list=new ArrayList<String>();  
         list.add("Ravi");  
         list.add("Vijay");  
         list.add("Ajay");  
           
         HashSet<String> set=new HashSet(list);  
         set.add("aaurav");  
         Iterator<String> i=set.iterator();  
         while(i.hasNext())  
         {  
         System.out.println(i.next());  
         }  
	}

}
