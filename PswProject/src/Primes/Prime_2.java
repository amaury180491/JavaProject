package Primes;

public class Prime_2 {
	
	   public static int NumberOfPrimes = 30;
	   public static int currentNumber = 2;
	   public static int count = 0;
	   public static int lastPrime = 2;
	   public static long output;

    public static void main(String[] args) {
    	
    	long lStartTime = System.nanoTime();
    	
        while (currentNumber < NumberOfPrimes) {

            boolean prime = true;

            int top = (int)Math.sqrt(currentNumber) + 1;

            for (int i = 2; i < top; i++) {
                if (currentNumber % i == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                count++;
                lastPrime = currentNumber;
                System.out.println("prime number = " + lastPrime);
            }
            
            if (currentNumber == 2) {
             currentNumber++;
            } else {
                currentNumber = currentNumber + 2;
            }
        }
        
        long lEndTime = System.nanoTime();
        output = lEndTime - lStartTime;  
        System.out.println("LAST PRIME = " + lastPrime);
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);	      
    } 
}
