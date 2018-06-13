import static org.junit.Assert.*;


import org.junit.Test;

public class PswRadomTest {

  private static String capitalLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
  private static String numbers = "0123456789";
  private static String specialSimbols = "~`!@#$%^&*()-_=+\\\\\\\\\\\\\\\\|;:\\\\\\\\'\\\\\\\\\\\\\\\",<.>/?[]{}";
  private static String ambiSimb = "iILl1oO0";
  
  
  @Test
  public void run() {
	  
	  pSWExcAllLettersExceptSpecialLetters();
	  pSWAllOptions();
	  pSWDefault();
	  pSWnumbers();
	  pSWcapitalLetter();
	  pSWlowercaseLetters();
	  pSWCapitalLowernumbers();
	  pSWspecialSimbols();
	  pSWNoAmbiSimb();
	  pSWLenght();
  }
  
  public void pSWcapitalLetter() {
	  
    String[] args = {"-U"};
    new PwdGen().main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
  }
  
  public void pSWlowercaseLetters() {
	  
    String[] args = {"-L"};
    new PwdGen().main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
  }

  public void pSWnumbers() {
	  
    String[] args = {"-N"};
    new PwdGen().main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
  }
  

  public void pSWCapitalLowernumbers() {
	  
    String[] args = {"-U", "-L", "-N"};
    new PwdGen().main(args);
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
  }
  

  public void pSWspecialSimbols() {
	  
    String[] args = {"-S"};
    new PwdGen().main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, specialSimbols));
  }

  public void pSWNoAmbiSimb() {
     
    String[] args = {"-E:0123456789"};
    new PwdGen().main(args);  
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
  }
  

  public void pSWLenght() {
    
    String[] args = {"-Size:10"};
    new PwdGen().main(args);
    assertEquals(10, (PwdGen.generatedPassword.length()));
  }

  public void pSWAllOptions() {

    String[] args = {"-E:0123456789", "-U", "-L", "-S", "-Size:30"};
    new PwdGen().main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, specialSimbols));
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertEquals(30, (PwdGen.generatedPassword.length()));
  } 
  
  public void pSWDefault() {
    
    String[] args = {"-A"};
    new PwdGen().main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertEquals(16, (PwdGen.generatedPassword.length()));
  }
  
  
  public void pSWExcAllLettersExceptSpecialLetters() {
    
    String[] args = {"-Size:30", "-U", "-N", "-L", "-S", "-E:ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"};
    new PwdGen().main(args);  
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, specialSimbols));
    assertEquals(30, (PwdGen.generatedPassword.length()));
  }
  

  public void m_wait(int time) {
	  
	  try        
	  {
	      Thread.sleep(time);
	  } 
	  catch(InterruptedException ex) 
	  {
	      Thread.currentThread().interrupt();
	  }
  }
  
}
