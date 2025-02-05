package dev.desktop;
// import file processing packages and scanner
import java.util.Scanner;
import java.io.File;

// the main app class for executing code.
public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Error!:No input files!");
            System.exit(64);
        }
        File file = new File(args[0]);
        // read logic
    }
}