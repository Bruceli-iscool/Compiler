package dev.desktop;
// import file processing packages and scanner
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// the main app class for executing code.
public class App {
    public static String content = "";
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Error!:No input files!");
            System.exit(64);
        }
        // read logic
        try {
            File file = new File(args[0]);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                content = content + reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error!:File not Found!");
            System.exit(126);
        }
        System.out.println(content);
    }
}