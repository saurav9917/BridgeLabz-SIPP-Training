package JavaStreams;

import java.io.*;

public class FileCopy {

	public static void main(String[] args) {
		String sourcePath = "src/JavaStreams/source.txt";
		String destinationPath = "src/JavaStreams/destination.txt";

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			File sourceFile = new File(sourcePath);

			// Check if source file exists
			if (!sourceFile.exists()) {
				System.out.println("Source file does not exist: " + sourcePath);
				return;
			}

			// Create input and output streams
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(destinationPath); 

			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			System.out.println("File copied successfully to: " + destinationPath);

		} catch (IOException e) {
			System.out.println("An error occurred while copying the file: " + e.getMessage());
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println("Failed to close streams: " + e.getMessage());
			}
		}
	}
}
