public class NodeStmtIfThenElse extends NodeStmt {

    private NodeBoolExpr boolexpr;
    private NodeStmt ifThenStmt;
    private NodeStmt elseStmt;

    public NodeStmtIfThenElse(NodeBoolExpr boolexpr, NodeStmt ifThenStmt, NodeStmt elseStmt) {
        super(null,boolexpr,null);
        this.boolexpr = boolexpr;
        this.ifThenStmt = ifThenStmt;
        this.elseStmt = elseStmt;
    }

    public NodeBoolExpr getBoolexpr() {
        return boolexpr;
    }

    public NodeStmt getIfThenStmt() {
        return ifThenStmt;
    }

    public NodeStmt getElseStmt() {
        return elseStmt;
    }

    @Override
    public double eval(Environment env) throws EvalException {
        if (boolexpr.eval(env) != 0) {
           return ifThenStmt.eval(env);
        } else {
            return  elseStmt.eval(env);
        }
    }

}
