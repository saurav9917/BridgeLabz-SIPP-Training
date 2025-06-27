import java.util.Scanner;
public class LongestWordInString {
    public static String findLongestWord(String str) {
        String longestWord = "", currentWord = "";
        int longestWordLength = 0, currentLength = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                currentWord += ch;
                currentLength++;
            } else {
                if (currentLength > longestWordLength) {
                    longestWord = currentWord;
                    longestWordLength = currentLength;
                }
                currentWord = "";
                currentLength = 0;
            }
        }
        if (currentLength > longestWordLength) {
            longestWord = currentWord;
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Longest Word in the string: " + findLongestWord(str.trim()));
    }
}
