import java.util.Scanner;

public class Lexographical {
    public static String compareLexicographically(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 < ch2) {
                return "\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order";
            } else if (ch1 > ch2) {
                return "\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order";
            }
        }

        // If all characters so far are equal, shorter string is smaller
        if (len1 < len2) {
            return "\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order";
        } else if (len1 > len2) {
            return "\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order";
        } else {
            return "Both strings are equal lexicographically";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        System.out.println(compareLexicographically(str1, str2));
    }
}
