import java.util.Scanner;

public class SubstringOccurences {
    public static int countOccurrence(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length(); // Move past the found substring
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter a substring: ");
        String substring = sc.nextLine();
        System.out.println("Occurrence of the substring in the string is: " + countOccurrence(str, substring));
    }
}