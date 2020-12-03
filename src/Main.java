import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //FrontEnd f = new FrontEnd();
        String defaultTempDir = System.getProperty("java.io.tmpdir");
        PrintWriter out;
        Scanner fileScanner;
        try {
            File temp = File.createTempFile("temp", ".txt");
            out = new PrintWriter(temp);
            out.print("Lorem ipsum");
            out.println("dolor sit amet.");
            out.close();
            fileScanner = new Scanner(temp);
            while (fileScanner.hasNextLine()) {
                String s = fileScanner.nextLine();
                System.out.print(s);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
