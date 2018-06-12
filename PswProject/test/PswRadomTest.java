import static org.junit.Assert.*;

import org.junit.Test;

public class PswRadomTest {

  private static String capitalLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
  private static String numbers = "0123456789";
  private static String specialSimbols = "~`!@#$%^&*()-_=+\\\\\\\\\\\\\\\\|;:\\\\\\\\'\\\\\\\\\\\\\\\",<.>/?[]{}";
  private static String ambiSimb = "iILl1oO0";
  
  @Test
  public void pSWcapitalLetter() {
    
    String[] args = {"-U"};
    PwdGen.main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
  }
  
  @Test
  public void pSWlowercaseLetters() {
    
    String[] args = {"-L"};
    PwdGen.main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
  }
  
  @Test
  public void pSWnumbers() {
    
    String[] args = {"-N"};
    PwdGen.main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
  }
  
  @Test
  public void pSWCapitalLowernumbers() {
    
    String[] args = {"-U", "-L", "-N"};
    PwdGen.main(args);
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
  }
  
  @Test
  public void pSWspecialSimbols() {
    
    String[] args = {"-S"};
    PwdGen.main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, specialSimbols));
  }
  
  @Test
  public void pSWNoAmbiSimb() {
    
    String[] args = {"-E:0123456789"};
    PwdGen.main(args);  
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
  }
  
  @Test
  public void pSWLenght() {
    
    String[] args = {"-Size:10"};
    PwdGen.main(args);
    assertEquals(10, (PwdGen.generatedPassword.length()));
  }
  
  @Test
  public void pSWAllOptions() {
    
    String[] args = {"-E:0123456789", "-U", "-L", "-S", "-Size:10"};
    PwdGen.main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, specialSimbols));
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertEquals(10, (PwdGen.generatedPassword.length()));
  } 
  
  @Test
  public void pSWDefault() {
    
    String[] args = {"-S"};
    PwdGen.main(args);  
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertEquals(16, (PwdGen.generatedPassword.length()));
  }
  
  @Test
  public void pSWExcAllLettersExceptSpecialLetters() {
    
    String[] args = {"-Size:30", "-U", "-N", "-L", "-S", "-E:ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"};
    PwdGen.main(args);  
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, capitalLetter));
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, lowercaseLetters));
    assertFalse(PwdGen.stringStringComparator(PwdGen.generatedPassword, numbers));
    assertTrue(PwdGen.stringStringComparator(PwdGen.generatedPassword, specialSimbols));
    assertEquals(30, (PwdGen.generatedPassword.length()));
  }
  

}
