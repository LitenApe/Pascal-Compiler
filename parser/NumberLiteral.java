package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class NumberLiteral extends UnsignedConstant{

    int digit;

    public NumberLiteral(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(""+digit);
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<NumberLiteral> on line " + lineNum;
    } /* End of identify */

    public static NumberLiteral parse(Scanner s) {
        enterParser("number literal");

        NumberLiteral numberLiteral = new NumberLiteral(s.curLineNum());

        s.test(intValToken);
        numberLiteral.digit = s.curToken.intVal;
        s.skip(intValToken);

        leaveParser("number literal: " + numberLiteral.digit);
        return numberLiteral;
    }/*End parse*/
}/*End class*/
