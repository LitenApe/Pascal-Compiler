package parser;

public class Constant extends PascalSyntax{

    public Constant(int n){
        super(n);
    }/*End constructor*/

    @Override
    public String identify(){
        return "<constant> on line " + lineNum;
    }/*End identify*/

    @Override
    public void prettyPrint(){

    }/*End prettyPrint*/
}/*End class*/
