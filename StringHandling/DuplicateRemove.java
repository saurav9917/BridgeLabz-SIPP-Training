import java.util.Scanner;
public class DuplicateRemove {
    public static String removeDuplicates(String input) {
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (result.indexOf(currentChar) == -1) {
                result += currentChar;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String modified = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + modified);
    }
}