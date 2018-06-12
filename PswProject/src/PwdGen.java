import java.util.Random;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PwdGen {


  public static String generatedPassword;
  private static String pwd_1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  public static String pwd_2 = "~`!@#$%^&*()-_=+\\\\\\\\|;:\\\\'\\\\\\\",<.>/?[]{}";
  private static String pwd_CapitalLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static String pwd_LowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
  private static String pwd_Numbers = "0123456789";
  private static String pwd_NoAmbiSimb = "iILl1oO0";
  private static String pwd_ExcSymbols ="";
  private static String newPwd ="";
  private static int pwdLength = 16;
  private static int pwdNum = 1;
  private static boolean capitalLetter = false;
  private static boolean lowercaseLetters = false;
  private static boolean numbers = false;
  private static boolean specialSimb = false;
  private static boolean ambiSimb = false;
  private static boolean excSymbols = false;
  private static boolean copyClipBoard = false;
  private static boolean ExcAllCapitalLetters = false;
  private static boolean ExcAllLowercaseLetters = false;
  private static boolean ExcAllNumbers = false;
  private static char chart_1;
  //private static String[] args = {"-E:0123456789"} ;
  
  public static void main(String[] args) { 
    // This "for" control how many psw should be generated
    for (int j = 0; j < pwdNum; j++) {
      
      try {
    // This "for" control how many instruction (commands) must be executed 
      for (int i = 0; i < args.length; i++) {
        
        if (args[i].contains("-E:")) {
          pwd_ExcSymbols = args[i].substring(3,args[i].length());
          excSymbols = true;
        } else if (args[i].contains("-Size:")) {
          pwdLength = Integer.parseInt(args[i].substring(6,args[i].length()));
        } else if (args[i].contains("-T:")) {
          pwdNum = Integer.parseInt(args[i].substring(3,args[i].length()));
        } else {
          switch(args[i]) {
          case "-U":
            capitalLetter = true;
            break;
            
          case "-L":
            lowercaseLetters = true;
            break;
            
          case "-N":
            numbers = true;
            break;
          
          case "-S":
            specialSimb = true;
            break;
            
          case "-A":
            ambiSimb = true;
            break;
            
          case "-C":
            copyClipBoard = true;
            break;
            
          case "-?":
            commandInformation();
            System.exit(0);
            
          default:
            commandInformation();
            System.exit(0);
          }
        }       
      }
    } catch(ArrayIndexOutOfBoundsException exc) {
  
    }
      
      ValidateDefault();    
      
      if(pwd_ExcSymbols != "") {
        validateExcSymbols(); 
      }
      
  //Perform Generator PSW Method
  PwdGen.PwdGenMethod(pwdLength);
    }
  }
  
  
  public static void PwdGenMethod (int length) {
    PwdGen.randomString(length);
  }
  
  public static void randomString (int length)  {
    
    for (int i = 1; i<=length; i++) { 
      newPwd = newPwd+getRandomChar();
      
      if (specialSimb == true && getRandomNumber(0, 2) == 0 ) {
        newPwd = newPwd+getSpecialRandomChar() ;
        i++;
      } 
    }
    //Here is where the password is printed
    System.out.println(newPwd);
    //For testing purposes
    generatedPassword = newPwd;
    
    if(copyClipBoard==true) {
      testClipBoard(newPwd);
    }
    
    newPwd =""; 
  }
  
  //Method to obtain a random number between a range (Min and Max).
  public static int getRandomNumber(int min, int max) { 
    Random Rn = new Random();
    return Rn.nextInt(max - min) + min;
  }
  
  //Method to obtain a random char
  public static char getRandomChar() {
    
    if((ExcAllCapitalLetters == false && ExcAllLowercaseLetters == false && ExcAllNumbers == false) || (ExcAllCapitalLetters == true || ExcAllLowercaseLetters == true || ExcAllNumbers == true)){
      chart_1 = pwd_1.charAt(getRandomNumber(0 , pwd_1.length()));
    } else {
      chart_1 = pwd_2.charAt(getRandomNumber(0 , pwd_2.length()));
    }
    
    
    if (capitalLetter == false) {
      if(charStringComparator(chart_1, pwd_CapitalLetter) == true) {
        getRandomChar();
      }
    }
    
    if (lowercaseLetters == false) {
      if(charStringComparator(chart_1, pwd_LowercaseLetters) == true) {
        getRandomChar();
      }
    }
        
    if (numbers == false) {
      if(charStringComparator(chart_1, pwd_Numbers) == true) {
        getRandomChar();
      }
    }
      
    if (ambiSimb == true) {
      if(charStringComparator(chart_1, pwd_NoAmbiSimb) == true) {
        getRandomChar();
      }
    }
      
    if (excSymbols == true) {
      if(charStringComparator(chart_1, pwd_ExcSymbols) == true) {
        getRandomChar();
      }
    }
        
    return chart_1;
  }
  
  //Method to obtain a  Special random chart
  public static char getSpecialRandomChar() { 
    chart_1 = pwd_2.charAt(getRandomNumber(0 , pwd_2.length()));
    
    if (excSymbols == true) {
      
      if (charStringComparator(chart_1, pwd_ExcSymbols) == true) {
        getSpecialRandomChar(); 
      }
    }
      
    return chart_1; 
  }
  
  //Method to clipboard a string
  public static void testClipBoard (String s) { 
    StringSelection selection = new StringSelection(s);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, selection);
  }
  
  //Method to compare a char for a string vs char, if the char is equal of one char of the string, this return true
  public static boolean charStringComparator(char c, String s) {
    
    for (int i = 0; i<s.length(); i++) {
      
      if (c == s.charAt(i)) {
        return true;
      } 
    }
    
    return false;
  }
  
  //Method to compare a string vs String, if the chars of String is equal of one char of the string, this return true
  public static boolean stringStringComparator(String passWord, String s) {
    
    for (int j = 0; j<passWord.length(); j++) {
      
      for (int i = 0; i<s.length(); i++){
        
        if (passWord.charAt(j) == s.charAt(i)) {
          return true;
        }
        
      }     
    }
    
    return false; 
  }
  
  //Method to validate if the password must be default or not
  public static void ValidateDefault() {
    
    if(capitalLetter == false && lowercaseLetters == false && numbers == false) {
      capitalLetter = true;
      lowercaseLetters = true;
      numbers = true;
    }

  }
  
  //Method to compare a string vs String, this one return how many times a char of the string is been repeated on the other string
    public static int stringStringComparator2(String symbols1, String symbols2) {
      
      int counter_1 = 0;
      
      for (int j = 0; j<symbols1.length(); j++) {
        
        for (int i = 0; i<symbols2.length(); i++){
          
          if (symbols1.charAt(j) == symbols2.charAt(i)) {
            counter_1++;
          }
          
        }     
      }
      
      return counter_1; 
    }
  
  //Method to validate if all excepted characters belong a class (capital Letters, lowercase letters) this kind of letter will be disabled
  public static void validateExcSymbols() {
    
    if(stringStringComparator2(pwd_ExcSymbols, pwd_CapitalLetter) == 26) {
      capitalLetter = false;
      ExcAllCapitalLetters = true;
    }
    
    if(stringStringComparator2(pwd_ExcSymbols, pwd_LowercaseLetters) == 26) {
      lowercaseLetters = false;
      ExcAllLowercaseLetters = true;
    }
    
    if(stringStringComparator2(pwd_ExcSymbols, pwd_Numbers) == 10) {
      numbers = false;
      ExcAllNumbers = true;
    }
    
    if(stringStringComparator2(pwd_ExcSymbols, pwd_2) == 50) {
      specialSimb = false;
    }
    
  }
  
  public static void commandInformation() {
    System.out.println("LOS SIGUIENTES COMANDOS DESCRIBEN EL USO Y CREACION DE LOS PASSWORDS AUTOGENERADOS\r\n" + 
        "-Size:16 Contraseña de 16 caracteres\r\n" + 
        "-U Incluir letras en mayúscula (Uppercase)\r\n" + 
        "-L Incluir letras en minúscula (Lowercase)\r\n" + 
        "-N Incluir números (Numbers)\r\n" + 
        "-S Incluir símbolos (Symbols). Entiéndase caracteres como: $%&()=# entre otros.\r\n" + 
        "-A Excluye los caracteres ambiguos: i, I, L, l, 1, o, O, 0\r\n" + 
        "-E:[]{}@ Excluir los símbolos suministrados. En este caso la contraseña generada no contendrá los caracteres []{}@\r\n" + 
        "-T:3 Generar 3 contraseñas (Total)\r\n" + 
        "-C Copia la contraseña generada en el ClipBoard para solo hacer CTRL + V y utilizarla. (Ver más adelante como hacerlo). Si el usuario genera múltiples contraseñas, solo la última se copiará al Clipboard.\r\n" + 
        "");
  }
  
}