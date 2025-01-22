import java.io.File;
import java.util.Scanner;

public class DirectorySize {
    public static void main(String[] args) {
        // Prompt the user to enter a directory or file
        System.out.println("Enter the directory path or a file: ");
        Scanner scanscan  = new Scanner(System.in);
        String directory = scanscan.nextLine();

        // Display the size
        long sizeInBytes = getSize(new File(directory));
        System.out.println(getSize(new File(directory)) + " bytes");
        System.out.println(sizeInBytes / (1024.0 * 1024) + " MB");
        System.out.println(sizeInBytes / (1024.0 * 1024 * 1024) + " GB");
    }

    public static long getSize(File file) {
        long size = 0; // Store the total size of all the files
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // ALl files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]); // Recursive call
            }
        }
        else { // base case
            size += file.length(); // Add the file's size
        }

        return size; // Return the total size
    }
}
