import java.util.Scanner;

public class ToggleString {
    public static String toggle(String input) {
        String str="";
        for(int i=0; i<input.length(); i++){
            char ch=input.charAt(i);
            if(Character.isUpperCase(ch)){
                str+=Character.toLowerCase(ch);
            }
            else
                str+=Character.toUpperCase(ch);
        }
        return str;   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("The Toggle string of "+input+" is " + toggle(input));
    }
}