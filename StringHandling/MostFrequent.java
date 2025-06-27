import java.util.Scanner;

public class MostFrequent {
    public static char findMostFrequentChar(String str) {
        int maxFreq = 0;
        char mostFreqChar = '\0';  // null character for default

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            int count = 0;

            // Count frequency of current character
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == current) {
                    count++;
                }
            }

            // Update max and result character
            if (count > maxFreq) {
                maxFreq = count;
                mostFreqChar = current;
            }
        }

        return mostFreqChar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char result = findMostFrequentChar(input);
        System.out.println("Most Frequent Character: '" + result + "'");
    }
}
