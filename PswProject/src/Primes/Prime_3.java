package Primes;

public class Prime_3 {

	public static long output;
	public static int n = 1000;

	
    // Driver Program to test above function
    public static void main(String args[])
    {
    	long lStartTime = System.currentTimeMillis();
    	
    	cribadeEratostenesPrimos(n);

        long lEndTime = System.currentTimeMillis();
        output = lEndTime - lStartTime;  
        System.out.println("Elapsed time in milliseconds: " + output);	        
    }
    
	public static void cribadeEratostenesPrimos(int n)
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
        
        
        
        findSpecialPrimes(convertPrimeArrayBooltoNumber(prime));
         
        // Print all prime numbers
//        for(int i = 2; i <= n; i++){
//            if(prime[i] == true) {
//            	System.out.println(i + " ");
//            }  
//        }
        
    }
	
	public static int[] convertPrimeArrayBooltoNumber(boolean prime[]) {
		
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
	
	/**
	 * Returns an Image object that can then be painted on the screen. 
	 * The url argument must specify an absolute {@link URL}. The name
	 * argument is a specifier that is relative to the url argument. 
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives 
	 * that draw the image will incrementally paint on the screen. 
	 *
	 * @param  prime  an absolute URL giving the base location of the image
	 * @return      the image at the specified URL
	 * @see         Image
	 */
	
	public static void findSpecialPrimes(int prime[]) {
		
		int j = 5;
		int indexAfterTen = 5;
		int contador = 0;
		String prime1;
		String prime2;
		String specialPrimes[] = new String[prime.length];
	
	
		
		for(int i = 5; i<prime.length; i++) {
			
			for(j = indexAfterTen; j < prime.length; j++) {
				
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
					
					if(twoNumbersEqual(prime1, prime2) == true) {
						if(!ifAlreadyExist(prime1, specialPrimes)) {
							specialPrimes[contador] = prime1;
							contador++;
						}
						
						if(!ifAlreadyExist(prime2, specialPrimes)) {
							specialPrimes[contador] = prime2;
							contador++;
						}
					}
				}	
			}
		}
		
	    // Print all prime numbers
		int specialCounter = 0;
        for(int i = 0; i < specialPrimes.length; i++){
        	
                if(specialPrimes[i] != null) {
                	specialCounter++;
                 	System.out.println("Numero primo especial "+specialPrimes[i]);
                }
        }
        
    	System.out.println("Numeros primos especiales encontrados: "+specialCounter);
		
	}	
	
	
	
	public static boolean twoNumbersEqual(String a, String b) {
		
		int contador = 0;
		boolean strikePositionNumber[] = new boolean[a.length()];
		
		for(int i = 0; i<a.length(); i++) {
				
				for(int j = 0; j < b.length(); j++) {
					if(strikePositionNumber[j] != true) {
						
						if(a.charAt(i) == b.charAt(j)) {
							contador ++;
							strikePositionNumber[j] = true;
							break;
						}
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
			if(a.equals(b[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	
     

}
	

