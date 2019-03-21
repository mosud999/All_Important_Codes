package exception.hadling.java;

import org.testng.annotations.Test;

public class TryCatchFinally {
	
		/*	A finally block contains all the crucial statements that must be executed whether exception 
		 * occurs or not. The statements present in this block will always execute regardless of whether 
		 * exception occurs in try block or not such as closing a connection, stream etc.
		 * Syntax of Finally block
		 *  A finally block must be associated with a try block, you cannot use finally without a
		 *   try block. You should place those statements in this block that must be executed always.


			try {
			    //Statements that may cause an exception
			}
			catch {
			   //Handling exception
			}
			finally {
			   //Statements to be executed
			}*/
	@Test
	public void tryCatchFinally(){
	 try{  
		 int num=121/0;  
		 System.out.println(num);  
	      }  
	      catch(ArithmeticException e){
	         System.out.println("Number should not be divided by zero");
	      }  
	      /* Finally block will always execute
	       * even if there is no exception in try block
	       */
	      finally{
		 System.out.println("This is finally block");
	      }  
		}
	

}
