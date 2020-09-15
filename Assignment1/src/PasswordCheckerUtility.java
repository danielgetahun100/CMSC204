import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * PasswordCheckerUtility Class
 * @author steum
 *
 */
public final class PasswordCheckerUtility {

	/**
	 * Method used to check length of string
	 * @param pass string for which to check length
	 * @return true if length > 6 characters, otherwise throws Length exception
	 * @throws LengthException
	 */
	private static boolean checkLength(String pass) throws LengthException {
		if (pass.length()<6) 
			throw new LengthException();
		else
			return true;
	}

	/**
	 * Method to check if string has at least one upper case character
	 * @param pass string for which to check if it has upper case characters
	 * @return true if there's at least one upper case character, otherwise throws NoUpperAlphaException
	 * @throws NoUpperAlphaException
	 */
	private static boolean hasUpperAlpha(String pass) throws NoUpperAlphaException {
		if(pass.equals(pass.toLowerCase())) 
			throw new NoUpperAlphaException();
		else
			return true;
			
	}
	
	/**
	 * Method to check if string has at least one lower case character
	 * @param pass string for which to check if it has lower case characters
	 * @return true if there's at least one lower case character, otherwise throws NoLowerAlphaException
	 * @throws NoLowerAlphaException
	 */
	private static boolean hasLowerAlpha(String pass) throws NoLowerAlphaException {

		if(pass.equals(pass.toUpperCase())) 
			throw new NoLowerAlphaException();
		else
			return true;

	}
	
	/**
	 * Method to check if string has at least one digit
	 * @param pass string for which to check if it has at least one digit
	 * @return true if there's a digit, throws NoDigitException otherwise 
	 * @throws NoDigitException
	 */
	private static boolean hasDigit(String pass) throws NoDigitException {
		char[] pass2=pass.toCharArray();
		int count=0;
		for(int i=0;i<pass2.length;i++) {
			if(Character.isDigit(pass2[i])) {
				count++;
			}
		}
		if(count==0) {
			throw new NoDigitException();
		}
		else {
			return true;
		}

	}
	
	/**
	 * Method to check if string has at least one special character
	 * @param pass string for which to check if it has at least one special character
	 * @return true if there's a special character, throws NoSpecialCharacterException otherwise
	 * @throws NoSpecialCharacterException
	 */
	private static boolean hasSpecialChar(String pass) throws NoSpecialCharacterException {
		String reg="[a-zA-Z0-9]*";
		Pattern pat=Pattern.compile(reg);
		Matcher mat=pat.matcher(pass);
		
		if(mat.matches()) {
			throw new NoSpecialCharacterException();
		}
		else {
			return true;
		}
		

	}
	
	/**
	 * Method to check if a character doesn't repeat itself 3 or more times consecutively
	 * @param pass string to check if no character repeats 3 or more time consecutively
	 * @return true if no character repeats 3 or more time consecutively, throws InvalidSequenceException otherwise
	 * @throws InvalidSequenceException
	 */
	private static boolean isValidSequence(String pass) throws InvalidSequenceException {		
		/*
		Pattern pat=Pattern.compile("^.*(.)\\1\\1.*$");
		Matcher mat=pat.matcher(pass);
		if(mat.find()) {
			throw new InvalidSequenceException();
		}
		else {
			return true;
		}
		*/
		
		boolean isValid=true;
		for (int i=0;i<=pass.length()-2;i++) { 
			if(pass.charAt(i)==pass.charAt(i+1)) {
				if (pass.charAt(i)==pass.charAt(i+2)) {
					isValid=false;
					throw new InvalidSequenceException();
				}
				
			}
		}
		return isValid;
		
	}
	
	/**
	 * Method to check if a string fulfills all requirements of a valid password
	 * @param passwordString string to check validity for
	 * @return true if string is a valid password, false otherwise
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    NoSpecialCharacterException,
    InvalidSequenceException 
	{
		boolean len=false, up=false,low=false, dig=false, spec=false, seq=false, val=true;	
		try {
			len=checkLength(passwordString);
			up=hasUpperAlpha(passwordString);
			low=hasLowerAlpha(passwordString);
			dig=hasDigit(passwordString);
			spec=hasSpecialChar(passwordString);
			seq=isValidSequence(passwordString);
			
		}
		finally {
			if (len==true&&up==true&&low==true&&dig==true&&spec==true&&seq==true) {
				val=true;
			}
			else {
				val=false;
			}
		}
		return val;
	}
	
	/**
	 * Method to check if a string is a weak password (has between 6 and 9 characters)
	 * @param passwordString string to check if is weak or not
	 * @return true if weak, false otherwise
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException{
		boolean weak=false;
		if(passwordString.length()>=6 && passwordString.length()<=9) {
			weak=true;
		}
		
		return weak;
	}
	
	/**
	 * Method to find all invalid passwords from list of passwords
	 * @param passwords arrayList of string passwords
	 * @return an arrayList of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String>pass=new ArrayList<String>();
		String invdpass=null;
		for (int i=0;i<passwords.size();i++) {	
			try {
				invdpass=passwords.get(i);
				if(!isValidPassword(invdpass)) {
					invdpass=invdpass+"";
				}
			}
			catch(Exception e) {
				pass.add(invdpass+" "+e.getMessage());
			}
		}
		
		return pass;		
	}
}
