package dev.desktop;

// the ast nodes for the compiler
public class ASTnodes {

}

class PROGRAM extends ASTnodes{
    public PROGRAM() {

    }
}

class FUNCTION extends ASTnodes{
    String functionName;
    public FUNCTION(String name, String type) {
        functionName = name;
    }
}
class STATEMENT extends ASTnodes {
    public STATEMENT(ASTnodes statement) {

    }
}
class RETURN extends ASTnodes {
    int returnValue;
    public RETURN(int value) {
        returnValue = value;
    }
}