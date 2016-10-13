package parser;

import scanner.*;
import static scanner.TokenKind.*;
import main.Main;

public class ConstDecl extends PascalDecl{

    // name : = : constant : ;
    public NamedConst namedConstant= null;
    public Constant cnst = null;

    public ConstDecl(String id, int lNum){
        super(id, lNum);
    }/*Enc constructor*/

    @Override
    public void prettyPrint(){
        namedConstant.prettyPrint();
        Main.log.prettyPrint(" = ");
        cnst.prettyPrint();
        Main.log.prettyPrintLn(";");
    }/*End prettyPrint*/

    public static ConstDecl parse(Scanner s){
        enterParser("const decl");

        ConstDecl constD = new ConstDecl(s.curToken.id,s.curLineNum());

        constD.namedConstant = NamedConst.parse(s);

        s.skip(equalToken);
        constD.cnst = Constant.parse(s);

        s.skip(semicolonToken);

        leaveParser("const decl: " + constD.namedConstant.name);
        return constD;
    }

    @Override
    public String identify() {
        return "<ConstDecl> " + name + " on line " + lineNum;
    } /* End of identify */

    @Override
    public void checkWhetherAssignable(PascalSyntax where){

    }/*End checkWhetherAssignable*/

    @Override
    public void checkWhetherFunction(PascalSyntax where){

    }/*End checkWhetherFunction*/

    @Override
    public void checkWhetherProcedure(PascalSyntax where){

    }/*End checkWhetherProcedure*/

    @Override
    public void checkWhetherValue(PascalSyntax where){

    }/*End checkWhetherValue*/
}/*End class*/
