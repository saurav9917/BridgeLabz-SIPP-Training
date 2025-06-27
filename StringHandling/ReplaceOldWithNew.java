import java.util.Scanner;

public class ReplaceOldWithNew {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result += newWord;
            } else {
                result += words[i];
            }

            if (i != words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = sc.next();

        System.out.print("Enter the new word: ");
        String newWord = sc.next();

        String updatedSentence = replaceWord(sentence, oldWord, newWord);
        System.out.println("Updated sentence: " + updatedSentence);
    }
}
