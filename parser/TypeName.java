package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;
import main.*;

public class TypeName extends Type{

    NamedConst namedConstant = null;

    public TypeName(int lNum){
        super(lNum);
    }/*End constructor*/

    public static TypeName parse(Scanner s) {
        enterParser("type name");

        TypeName typeName = new TypeName(s.curLineNum());
        typeName.namedConstant = NamedConst.parse(s);

        leaveParser("type name");
        return typeName;
    }/*End parse*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<TypName> on line " + lineNum;
    } /* End of identify */
}/*End class*/