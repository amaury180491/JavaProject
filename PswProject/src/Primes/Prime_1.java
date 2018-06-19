package Primes;
import java.util.Scanner;

public class Prime_1 {

	public String s;
	 public boolean isPrime;
     public static int i =0;
     public static int x =0;
     public static int num =0;
     public static int n = 10000;
     public static int PrimeArray[] = new int[1000000];
     public static long output;

	public static void main(String[] args) {
		
		long lStartTime = System.nanoTime();

	      for (i = 1; i <= n; i++){ 
	    	  
	      int counter=0; 	
	      
		     for(num =i; num>=1; num--){
		    	 
			    if(i%num==0){
				counter = counter + 1;
			    }
			 }
	     
			 if (counter ==2){
				 PrimeArray[x]=i;
				 x++;
				 System.out.println("Prime numbers # "+x+" to n are :"+ i);
			 }	
	      }	
	      
	      long lEndTime = System.nanoTime();
	      output = lEndTime - lStartTime;  
	      System.out.println("Elapsed time in milliseconds: " + output / 1000000);	      
	}
	
	
	public static void circularsNumbers() {

		
	
		
		
	}
	
	

}
