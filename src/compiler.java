import java.util.*;
import java.io.File;
public class compiler {
    public static void main(String[] args) {
        String content = read(args[0]);
        if (args[1].equals("--lex")) {
            System.out.println(lex(content));
        }
    }
    public static String read(String path) }
    	String content = "";
        try (Scanner scanner = new Scanner(new File(filePath))) {
             while (scanner.hasNext()) {
                content += scanner.nextLine();
             }
        } catch (FileNotFoundException e) {
            System.out.println("Error!: File Not Found");
        }
	return content;
    }
    public static ArrayList<String> lex(String input) {
        return new ArrayList<String>();
    } 
}

