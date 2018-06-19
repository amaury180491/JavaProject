package Primes;

public class Prime_3 {

	public static long output;
	public static int n = 100;

	
    // Driver Program to test above function
    public static void main(String args[])
    {
    	long lStartTime = System.nanoTime();
    	
        CribadeEratostenesPrimos(n);

        long lEndTime = System.nanoTime();
        output = lEndTime - lStartTime;  
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);	        
    }
    
	public static void CribadeEratostenesPrimos(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        
        for(int i = 0; i < n; i++) {
        	prime[i] = true;
        }
            
         
        for(int p = 2; p*p <=n; p++){
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true){
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p) {
                	 prime[i] = false;
                }  
            }
        }
        
        
        
        FindSpecialPrimes(ConvertPrimeArrayBooltoNumber(prime));
         
        // Print all prime numbers
//        for(int i = 2; i <= n; i++){
//            if(prime[i] == true) {
//            	System.out.println(i + " ");
//            }  
//        }
        
    }
	
	public static int[] ConvertPrimeArrayBooltoNumber(boolean prime[]) {
		
		int count = 0;
		int count2 = 0;
		
		for(int i = 2; i<prime.length; i++) {
			
			if(prime[i]==true) {
				count++;
			}
		}
		
	     int primeNum[] = new int[count];
		
	     for(int i = 2; i<prime.length; i++) {
				
	    	 if(prime[i]==true) {
	    		 primeNum[count2] = i;
	    		 count2++;
	    	 } 
		}
	     
	     return primeNum;
		
	}
	
	public static void FindSpecialPrimes(int prime[]) {
		
		int j = 5;
		int indexAfterTen = 5;
		int contador = 0;
		String prime1;
		String prime2;
		String specialPrimes[] = new String[prime.length];
	
	
		
		for(int i = 5; i<prime.length; i++) {
			
			for(j = 5; j < prime.length; j++) {
				
				prime1 = Integer.toString(prime[i]);
				prime2 = Integer.toString(prime[j]);
				
				if(prime[i] != prime[j]) {
					if(prime2.length() > prime1.length()) {
						j = indexAfterTen;
						break;
					}
					
					if(prime1.length() > prime2.length()) {
						indexAfterTen = i;
						break;
					}
					
					if(TwoNumbersEqual(prime1, prime2) == true) {
						if(ifAlreadyExist(prime1, specialPrimes)) {
							specialPrimes[contador] = prime1;
						}
						
						if(ifAlreadyExist(prime2, specialPrimes)) {
							specialPrimes[contador] = prime2;
						}
					}
				}	
			}
		}
		
	    // Print all prime numbers
        for(int i = 0; i < specialPrimes.length; i++){
        	
                if(specialPrimes[i] != null) {
                 	System.out.println("Numero primo especial "+specialPrimes[i]);
                }
   
        }
		
	}	
	
	
	
	public static boolean TwoNumbersEqual(String a, String b) {
		
		int contador = 0;
		
		for(int i = 0; i<a.length(); i++) {
				
				for(int j = 0; j < b.length(); j++) {
					
					if(a.charAt(i) == b.charAt(j)) {
						contador ++;
						break;
					}
				}
				
				if(contador == 0) {
					break;
				}
		}
		
		if(contador == a.length()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	 public static boolean ifAlreadyExist(String a, String b[]) {
		
		for(int i = 0; i<b.length; i++) {
			if(b[i] == a) {
				return true;
			}
		}
		
		return false;
	}
	
	
     

}
	

