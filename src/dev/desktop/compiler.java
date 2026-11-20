package dev.desktop;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

// c compiler
public class compiler {
    public static void main(String[] args) throws FileNotFoundException {
            String content = read(args[0]);
            if (args[1].equals("--lex")) {
                System.out.println(lex(content));
            } else if (args[1].equals("--tree")) {
                // possible replacement with a bison generated parser.
                parser p = new parser(lex(content));
                System.out.println(p.tree());
            }
    }
    public static String read(String path) throws FileNotFoundException {
    	String content = "";
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {
            content += scanner.nextLine();
         }
         scanner.close();
        return content;
    }
    public static ArrayList<String> lex(String line) {
        ArrayList<String> result = new ArrayList<String>();
        String z = "";
        boolean ifString = false;
        String p = line;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '-' && !ifString && z.isEmpty() && i + 1 < p.length() && Character.isDigit(p.charAt(i + 1))) {
                z += c;
                continue;
            }
            switch (c) {
                case '(':
                case ')':
                case ';':
                case '=':
                case '+':
                case '-':
                case '*':
                case '/':
                case '{':
                case '}':
                case ':':
                case '%':
                    if (!z.isEmpty()) {
                        result.add(z);
                        z = "";
                    }
                    result.add(String.valueOf(c));
                    break;
                case '"':
                    if (!z.isEmpty() && ifString) {
                        ifString = false;
                        result.add(z);
                        z = "";
                    } else {
                        ifString = true;
                    }
                    result.add("\"");
                    break;
                case ' ':
                    if (!z.isEmpty() && !ifString) {
                        result.add(z);
                        z = "";
                    } else if (ifString) {
                        z += c;
                    }
                    break;
                default:
                    z += c;
                    break;
            }
        }
        if (!z.isEmpty()) {
            result.add(z);
        }
        return result;
    } 
}

