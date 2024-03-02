package View;

import Libary.Validation;

public class FileView {

    public static String getInputPath() {
        System.out.print("Please input Path: ");
        return Validation.checkInputString();
    }

    public static void displayResult(String disk, String extension, String fileName, String path) {
        System.out.println("Disk: " + disk);
        System.out.println("Extension: " + extension);
        System.out.println("File name: " + fileName);
        System.out.println("Path: " + path);
    }
}
