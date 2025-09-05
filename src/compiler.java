import java.util.*;
import java.io.File;
public class compiler {
    public static void main(String[] args) {
        String content = read(args[0]);
        if (args[1].equals("--lex")) {
            System.out.println(lex(content));
        }
    }
    public static String read(String path) {
        return "";
    }
    public static ArrayList<String> lex(String input) {
        return new ArrayList<String>();
    } 
}

