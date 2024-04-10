package txt.file;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the source filename from where you have to read: ");
        String a = sc.nextLine();
        File inputFile = new File(a);

        System.out.println("Enter the destination filename where ypu have to write: ");
        String b = sc.nextLine();
        File toUpperCaseFile = new File(b);

        toUpperCase(inputFile, toUpperCaseFile);
    }


    public static void toUpperCase(File inputFile, File toUpperCaseFile) {
        BufferedReader inputBR = null;

        try {
            String line;

            PrintWriter toUpperCasePW = new PrintWriter(toUpperCaseFile);
            inputBR = new BufferedReader(new FileReader(inputFile));
            while ((line = inputBR.readLine()) != null) {
                toUpperCasePW.println(line.toUpperCase());
            }
            toUpperCasePW.close();
        } catch (IOException e) {
            System.out.println("The file cannot be write! Error: " + e);
        } finally {
            try {
                if (inputBR != null) inputBR.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}