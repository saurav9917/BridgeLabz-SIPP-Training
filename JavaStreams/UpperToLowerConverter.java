package JavaStreams;

import java.io.*;

public class UpperToLowerConverter {

    public static void main(String[] args) {
    	String inputFile = "src/JavaStreams/source.txt";
		String outputFile = "src/JavaStreams/destination.txt";

        // Character encoding (UTF-8 for better compatibility)
        String encoding = "UTF-8";

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), encoding)
            );

            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), encoding)
            );
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert line to lowercase and write
                writer.write(line.toLowerCase());
                writer.newLine(); // preserve original line breaks
            }

            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}

