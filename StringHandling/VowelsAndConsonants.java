import java.util.*;
public class VowelsAndConsonants
{
    public static void main(String[] args)
    { 
        Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
	VowelsAndConsonants ob = new VowelsAndConsonants();
	System.out.println(ob.count(str.toUpperCase()));
    }
    public String count(String str)
    {
        int vowels = 0, consonants = 0;
        for(int i = 0; i < str.length(); i++)
        {     
            char ch = str.charAt(i);
	    if(Character.isLetter(ch))
	    {
		if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') vowels++;
		else consonants++;
	    }
	}
	return "The number of vowels is "+vowels+" and the number of consonants is "+consonants; 
    }
}