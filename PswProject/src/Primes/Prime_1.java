package Primes;

public class Prime_1 {

    public static void main(String[] args) {
    	
    	long tiempoInicio = System.nanoTime();
        int count = 0; 
        int prime_count=0;
        String CircularPrimes = ""; 
        
      for (long i = 2; i < 1000000; i++) {
          if(isprime(i)){
              prime_count++;
            String num = i + "";
            boolean a = false;
            String temp = num;
            
            for (int j = 0; j < num.length(); j++) {
                temp = temp.charAt(temp.length() - 1) + temp;
                temp = temp.substring(0, temp.length() - 1);
                
            if(!isprime(Long.parseLong(temp))){
                a=false;
               break; 
            }else{
                a=true;
            }
            }
            if (a) {
            	CircularPrimes = CircularPrimes + temp + " ";
                count++;
            }
      }   
        }
      
  	long tiempoFinal = System.nanoTime();
  	System.out.println("el tiempo es : "+ ((tiempoFinal - tiempoInicio) / 1000000000) + " Segundos");
  	System.out.println("el tiempo es : "+ ((tiempoFinal - tiempoInicio) / 1000000) + " Milisegundos");
  	
        System.out.println("Conteo de primos : "+prime_count);
        System.out.println("Numeros primos circulares detectados :" + count);
        System.out.println("Numeros primos circulares detectados (Print) :" + CircularPrimes);
    }
    static boolean isprime(long num){
            
            boolean prime = true;
            if (num == 2) {
                prime = true;
            } else if (num % 2 == 0) {
                prime = false;
            } else {
                for (int j = 3; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        prime = false;
                    }
                }
            }
      return prime; 
    }
}