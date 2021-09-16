import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

	//Checks to make sure that the passwords are the same
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
	if (password.equals (passwordConfirm)) {
	}else  {
		throw new UnmatchedException("Password does not match.");
	}
	}
	
	//checks if they are the same and returns them
	public static boolean comparePasswordsWithReturn(String password,String passwordConfirm) {
		//makes sure that password and passwordConfirm are the same using .equals
		if (password.equals (passwordConfirm)) {
			return true;
		}else {
			return false;
		}
		}	
	
	//method for comparing teh new arrat lists
	public static ArrayList<String> getInvalidPasswords(ArrayList <String> passwords){
		try {
			File txtFile = new File("txt.txt");
			//make scanner
			Scanner myScanner = new Scanner(txtFile);
			while (myScanner.hasNext()) {
				String fails = myScanner.next();
				passwords.add(fails);
			}
				myScanner.close();
		}
		catch(Exception e) {
			System.out.println("Error has occured.");
		}
		return passwords;
	}
	
	public static boolean hasBetweenSixAndNineChars(String password)  {
		if (password.length() >= 5 && password.length() <= 8) {
			System.out.println("Password is OK but weak");
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean hasDigit(String password)  throws NoDigitException {
		int count = 0;
		char[] chars = password.toCharArray();
	      for(char c : chars){
	         if(Character.isDigit(c)){
	        	 count++;
	         }
	      }
	      if(count >=1) {
	    	  return true;
	      }else {
	    	  throw new NoDigitException("The password must contain at least one digit.");
	      }
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		int count = 0;
		char[] chars = password.toCharArray();
	      for(char c : chars){
	         if(Character.isLowerCase(c)){
	        	 count++;
	         }
	      }
	      if(count >= 1) {
	    	  return true;
	      }else {
	    	  throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character.");
	      }
	}

	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
		char passchar[] = password.toCharArray();
		boolean fail=true;
		for(int i = 0; i < password.length()-2; i++) {
	        if(passchar[i] == passchar[i+1] && passchar[i] == passchar[i+2]) {
	        	fail = false;
	        }
		}
		if(fail == false) {
			throw new InvalidSequenceException("The password cannot contain more than two of the same characters in sequence");
		}else {
			return fail;
		}
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(password);
        if(hasSpecial.find()) {
        	return true;
        }else {
        	throw new NoSpecialCharacterException("The password must contain at least one special character");
	}
	}

        public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        	int count = 0;
    		char[] chars = password.toCharArray();
    	      for(char c : chars){
    	         if(Character.isUpperCase(c)){
    	        	 count++;
    	         }
    	      }
    	      if(count >=1) {
    	    	  return true;
    	      }else {
    	    	  throw new NoUpperAlphaException("The password must contain at least one Uppercase alphabetic character.");
    	      }
        }
        
        public static boolean isValidLength(String password) throws LengthException {
        	
        	int length = password.length();
        	if(password.length() >= 5) {
        		return true;
        	}else {
        		throw new LengthException("The password does not meet required length");
        	}
        }

        public static boolean isWeakPassword(String password) throws WeakPasswordException {
        	if (password.length() >= 5 && password.length() <= 8) {
    			System.out.println("Password is OK but weak");
    			return true;
    		}else {
    			throw new WeakPasswordException("invalid Length.");
    		}
        }
 
        public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        	boolean error = true;
        	
        	if (hasDigit(password) == true) {
        	}else {
        		error = false;
  	    	  throw new NoDigitException("The password must contain at least one digit.");
        	}
        	
        	if (hasLowerAlpha(password) == true) {
        	}else {
  	    	  	throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character.");
        	}
        	
        	if (hasSameCharInSequence(password) == true) {
        	}else {
        		error = false;
    			throw new InvalidSequenceException("The password cannot contain more than two of the same characters in sequence");
        	}
        	
        	if (hasSpecialChar(password) == true) {
        	}else {
        		error = false;
            	throw new NoSpecialCharacterException("The password must contain at least one special character");
        	}
        	
        	if (hasUpperAlpha(password) == true) {
        	}else {
        		error = false;
  	    	  throw new NoUpperAlphaException("The password must contain at least one Uppercase alphabetic character.");
        	}
        	
        	if (isValidLength(password) == true) {
        	}else {
        		error = false;
        		throw new LengthException("The password does not meet required length");
        	}
        	return error;
        }



}