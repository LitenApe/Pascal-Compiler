package parser;

import java.util.ArrayList;
import main.Main;
import scanner.*;
import static scanner.TokenKind.*;

public class ProcCallStatm extends Statement{

    public NamedConst namedConst = null;
    public ArrayList<Expression> exp = new ArrayList<>();
    public ProcDecl procRef = null;

    public ProcCallStatm(int n){
        super(n);
    } /* End of constructor */

    @Override
    public void check(Block curScope, Library lib){
        System.out.println("[x] Procedure Call Statement: "+lineNum);
        namedConst.check(curScope, lib);

        PascalDecl pd = curScope.findDecl(namedConst.toString(), this);
        procRef = (ProcDecl) pd;

        ArrayList<ParamDecl> list = null;

        if (procRef.paramDecl != null){
            list = procRef.paramDecl.listOfParamDecls;
        }
        for(Expression e : exp){
            e.check(curScope, lib);
            if (list != null){
                types.Type t = list.get(exp.indexOf(e)).type;
                System.out.println("----------------------------expression type: "+t);
                System.out.println("----------------------------expression type: "+e);
                System.out.println("----------------------------expression type: "+exp.indexOf(e));
                System.out.println("----------------------------expression type: "+this);
                t.checkType(e.type,"param #"+(exp.indexOf(e)+1),this,"Param type mismatch!");
            }
        }

    }

    @Override public String identify() {
        return "<proc call statm> on line " + lineNum;
    } /* End of identify */

    @Override
    public void prettyPrint() {
        namedConst.prettyPrint();
        if (!exp.isEmpty()) {
            Main.log.prettyPrint("(");
            for(Expression ep : exp){
                ep.prettyPrint();
                if(ep != exp.get(exp.size() - 1)){
                    Main.log.prettyPrint(", ");
                }
            }
            Main.log.prettyPrint(")");
        }
    }

    public static ProcCallStatm parse(Scanner s) {
        enterParser("proc call");
        ProcCallStatm procCall = new ProcCallStatm(s.curLineNum());

        procCall.namedConst = NamedConst.parse(s);

        if(s.curToken.kind == leftParToken){
            s.skip(leftParToken);
            while(true){
                procCall.exp.add(Expression.parse(s));

                if(s.curToken.kind != commaToken){
                    break;
                }else{
                    s.skip(commaToken);
                }
            }
            s.skip(rightParToken);
        }

        leaveParser("proc call");
        return procCall;
    }

} /* End of class */
