import java.util.*;
public class StringReverse
{
    public static void main(String[] args)
    { 
        Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
	System.out.println(reverse(str));
    }
    public static String reverse(String str)
    {
        String rev = "";
	for(int i = str.length()-1; i>=0; i--)
	{
	    char ch = str.charAt(i);
	    rev+=ch;
	}
        return rev;
    }
}