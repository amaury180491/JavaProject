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
    
    /**
     * Genera numeros primos de 0 hasta n
     * 
	 * @param n rango maximo a generar numeros primos.
	 */
    
	public static void cribadeEratostenesPrimos(int n)
    {
        // Se crea un array booleano "prime[0..n]" y se inicializa
        // todas las entradas seran true. un valor n de prime[i] sera
        // falso si no es primo, de lo contrario sera true.
        boolean prime[] = new boolean[n+1];
        
        for(int i = 0; i < n; i++) {
        	prime[i] = true;
        }
            
         
        for(int p = 2; p*p <=n; p++){
            // si prime[p] no cambia, entonces se considera primo
            if(prime[p] == true){
                // actualizar todos los multiplos de "p"
                for(int i = p*2; i <= n; i += p) {
                	 prime[i] = false;
                }  
            }
        }
        
        
        
        findSpecialPrimes(convertPrimeArrayBooltoNumber(prime));
         
        // Imprime todos los numeros primos
//        for(int i = 2; i <= n; i++){
//            if(prime[i] == true) {
//            	System.out.println(i + " ");
//            }  
//        }
        
    }
	
	  /**
     * Convierte un array booleano de numeros primos
     * a un array int de numeros primos.
     * 
	 * @param prime[] Array de numeros primos en booleano.
	 * @return Array int de numeros primos.
	 */
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
     * Busca los numeros primos "especiales" a partir de un array de numeros primos suministrado.
     * 
	 * @param prime[] Array de numeros primos.
	 */
	public static void findSpecialPrimes(int prime[]) {
		
		int j = 5;
		int indexAfterTen = 5;
		int contador = 0;
		String prime1;
		String prime2;
		String specialPrimes[] = new String[prime.length];
	
	
		//Se empieza desde el index 5 del array debido que los numeros primos 2 3 5 7 se sabe de antemano que no pueden ser "especiales"
		for(int i = 5; i<prime.length; i++) {
			//for interno para recorrer un segundo array de primos e ir comparando para encontrar parejas, trios etc de primos "especiales"
			for(j = indexAfterTen; j < prime.length; j++) {
				//Se declaran dos enteros el cual son numeros primos que seran comparados.
				prime1 = Integer.toString(prime[i]);
				prime2 = Integer.toString(prime[j]);
				//if para controlar que no se comparen numeros primos de menor y mayor digito EJ: 19 vs 103
				if(prime[i] != prime[j]) {
					if(prime2.length() > prime1.length()) {
						j = indexAfterTen;
						break;
					}
					//if para controlar que no se comparen numeros primos de menor y mayor digito, si esto se cumple el index del
					//otro array de primos se ubica en el principio de el siguiente numero hablando de tamaño en digitos.
					if(prime1.length() > prime2.length()) {
						indexAfterTen = i;
						break;
					}
					//Se verifica si los dos numeros primos a comparar son "especiales"
					if(twoNumbersEqual(prime1, prime2) == true) {
						//si existe el numero primo "especial" en el array no se ingresa, de lo contrario se agrega 
						if(!ifAlreadyExist(prime1, specialPrimes)) {
							specialPrimes[contador] = prime1;
							contador++;
						}
						//si existe el numero primo "especial" en el array no se ingresa, de lo contrario se agrega
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
	
	
	 /**
     * Compara dos Strings (Numeros primos) y devuelve true si todos los caractares del primer String estan incluidos en el segundo String. 
     * 
	 * @param a 1er numero primo.
	 * @param b 2do numero primo.
	 * @return True si los dos Strings comparten los mismos caracteres, de lo contrario, devuelve false.
	 */
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
	
	 /**
     * Verifica si existe un numero primo "Especial" en el array de numeros primos "Especiales".
     * 
	 * @param numero primo.
	 * @param b[] Array de numeros primos "especiales"
	 * @return True si existe el numero primo de lo contrario arrojara false.
	 */
	 public static boolean ifAlreadyExist(String a, String b[]) {
		
		for(int i = 0; i<b.length; i++) {
			if(a.equals(b[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	
     

}
	

