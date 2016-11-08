package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

public abstract class PascalDecl extends PascalSyntax {
    String name, progProcFuncName;
    int declLevel = 0, declOffset = 0;
    types.Type type = null;

    PascalDecl(String id, int lNum) {
    	super(lNum);
    	name = id;
    }

    @Override
    public void genCode(CodeFile f){

    }

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<PascalDecl> on line " + lineNum;
    } /* End of identify */

    public static PascalDecl parse(Scanner s) {
        return null;
    }/*End parse*/

    @Override
    public void check(Block curScope, Library lib){

    }

    /**
     * checkWhetherAssignable: Utility method to check whether this PascalDecl is
     * assignable, i.e., may be used to the left of a :=.
     * The compiler must check that a name is used properly;
     * for instance, using a variable name a in "a()" is illegal.
     * This is handled in the following way:
     * <ul>
     * <li> When a name a is found in a setting which implies that should be
     *      assignable, the parser will first search for a's declaration d.
     * <li> The parser will call d.checkWhetherAssignable(this).
     * <li> Every sub-class of PascalDecl will implement a checkWhetherAssignable.
     *      If the declaration is indeed assignable, checkWhetherAssignable will do
     *      nothing, but if it is not, the method will give an error message.
     * </ul>
     * Examples
     * <dl>
     *  <dt>VarDecl.checkWhetherAssignable(...)</dt>
     *  <dd>will do nothing, as everything is all right.</dd>
     *  <dt>ConstDecl.checkWhetherAssignable(...)</dt>
     *  <dd>will give an error message.</dd>
     * </dl>
     */
    abstract void checkWhetherAssignable(PascalSyntax where);

    abstract void checkWhetherFunction(PascalSyntax where);
    abstract void checkWhetherProcedure(PascalSyntax where);
    abstract void checkWhetherValue(PascalSyntax where);
}
