package parser;

import scanner.*;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import main.Main;

public class ParamDeclList extends PascalSyntax{

    ArrayList<ParamDecl> listOfParamDecls;

    public ParamDeclList(int n){
        super(n);
        listOfParamDecls = new ArrayList<>();
    }

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[ ] Param Decl List");
        // for(ParamDecl pd : listOfParamDecls){
        //     pd.check(curScope, lib);
        //     curScope.findDecl(pd.typeName.toString(), pd.decl);
        // }
    }

    @Override
    public void prettyPrint(){
        Main.log.prettyPrint(" (");
        for (ParamDecl p : listOfParamDecls){
            p.prettyPrint();
            if (listOfParamDecls.get(listOfParamDecls.size()-1) != p){
                Main.log.prettyPrint("; ");
            }
        }
        Main.log.prettyPrint(")");
    }/*End prettyPrint*/

    @Override
    public String identify() {
        return "<ParamDeclList> on line " + lineNum;
    } /* End of identify */

    public static ParamDeclList parse(Scanner s){
        enterParser("param decl list");

        ParamDeclList pDeclList = new ParamDeclList(s.curLineNum());
        s.skip(leftParToken);

        while (s.curToken.kind != rightParToken){
            pDeclList.listOfParamDecls.add(ParamDecl.parse(s));

            if (s.curToken.kind == semicolonToken){
                s.skip(semicolonToken);
            }
        }

        s.skip(rightParToken);
        leaveParser("param decl list");
        return pDeclList;
    }/*End parse*/
}
