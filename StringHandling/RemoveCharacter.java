import java.util.Scanner;

public class RemoveCharacter {
    public static String remove(String input,char ch) {
        String result = "";
        for(int i = 0; i < input.length(); i++){
            char currentchar = input.charAt(i);
            if(ch!=currentchar){
                result += currentchar;                 
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Enter a Character: ");
        char ch = sc.next().charAt(0);
        System.out.println("The String after removal of specific character is "+remove(input, ch));
    }
}
