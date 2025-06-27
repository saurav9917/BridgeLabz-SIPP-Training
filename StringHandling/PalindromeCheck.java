import java.util.*;
public class PalindromeCheck
{
    public static void main(String[] args)
    { 
        Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
	System.out.println("Is the entered String \""+str+"\" palindrome --> "+isPalindrome(str));
    }
    public static boolean isPalindrome(String str)
    {
        String rev = "";
	for(int i = str.length()-1; i>=0; i--)
	{
	    char ch = str.charAt(i);
	    rev+=ch;
	}
        return str.equalsIgnoreCase(rev);
    }
}