package parser;

import scanner.*;
import static scanner.TokenKind.*;

public class Constant extends PascalSyntax{

    // prefix opr : unsigned opr

    PrefixOperator prefixOpr;
    UnsignedConstant uConstant;
    types.Type type;
    int constVal;

    public Constant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[x] Constant");

        uConstant.check(curScope, lib);
        type = uConstant.type;

        constVal = uConstant.constVal;

        if (prefixOpr != null) {
            String oprName = prefixOpr.prefix.toString();
            uConstant.type.checkType(lib.integerType, "Prefix "+oprName, this,"Prefix + or - may only be applied to Integers.");

            if (prefixOpr.prefix == subtractToken)
                constVal = -constVal;
        }
    }

    @Override
    public void prettyPrint(){
        if (prefixOpr != null){
            prefixOpr.prettyPrint();
        }
        uConstant.prettyPrint();
    }/*End prettyPrint*/

    @Override
    public String identify(){
        return "<constant> on line " + lineNum;
    }/*End identify*/

    public static Constant parse(Scanner s){
        enterParser("constant");

        Constant constant = new Constant(s.curLineNum());
        if (s.curToken.kind.isPrefixOpr()) {
            constant.prefixOpr = PrefixOperator.parse(s);
        }
        constant.uConstant = UnsignedConstant.parse(s);
        leaveParser("constant");
        return constant; //remember changing back
    }
}/*End class*/
