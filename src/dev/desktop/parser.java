package dev.desktop;

import java.util.ArrayList;

public class parser {
    private final ArrayList<String> tokens;
    ArrayList<String> modTokens = new ArrayList<>();
    public parser(ArrayList<String> content) {
        tokens = content;
    } 
    @SuppressWarnings("unchecked")
    public ArrayList<ASTnodes> tree() {
        ArrayList<ASTnodes> ast = new ArrayList<>();
        ast.add(new PROGRAM());
        modTokens = (ArrayList<String>) tokens.clone();
        String current;
        while (!modTokens.isEmpty()) {
            current = modTokens.get(0);
            modTokens.remove(0);
            if (current.matches("int")) {
                String type = current;
                current = modTokens.get(0);
                modTokens.remove(0);
                if (current.matches("[a-zA-Z]\\w*")) {
                    ast.add(new FUNCTION(current, type));
                    current = modTokens.get(0);
                    modTokens.remove(0);
                    if (current.matches("\\(")) {
                        current = modTokens.get(0);
                        modTokens.remove(0);
                        if (current.matches("[a-zA-Z]\\\\w*[0-9]+")) {
                            // work in progress currently cosumes and ignores arguments
                        } 
                        current = modTokens.get(0);
                        modTokens.remove(0);
                        if (current.matches("\\)")) {
                            current = modTokens.get(0);
                            // do not dispose of {
                            // just check if it exists
                            if (current.matches("\\{")) {
                                ast.addAll(parseFunction());
                            }
                        }
                    } else {
                        System.err.println("Error! Expected '('!");
                    }
                } else {
                    System.err.println("Error! Expected function identifier!");
                }
            }
        }
        System.out.println(ast.size());
        return ast;
    }
    public ArrayList<ASTnodes> parseFunction() {
        ArrayList<ASTnodes> funcAST = new ArrayList<>();
        String current = modTokens.get(0);
        modTokens.remove(0);
        int stack = 1;
        while (stack != 0 && !modTokens.isEmpty()) {
            current = modTokens.get(0);
            modTokens.remove(0);
            if (current.matches("return")) {
                current = modTokens.get(0);
                modTokens.remove(0);
                // in future non int return values may exist
                if (current.matches("[0-9]+")) {
                    funcAST.add(new STATEMENT(new RETURN(Integer.parseInt(current))));
                }
                current = modTokens.get(0);
                modTokens.remove(0);
                if (current.matches(";")) {
                    
                }
                // error handeling and reporting needed
            } else if (current.matches("}")) {
                stack -=1;
            }
        }
        return funcAST;
    }
}
