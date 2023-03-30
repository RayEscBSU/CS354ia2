public class NodeStmtIfThen extends NodeStmt{
/**
     * Constructs a statement node with the specified assignment node.
     *
     * @param assn the assignment node
     */
    private NodeBoolExpr boolexpr;
    private NodeStmt stmt;


    public NodeStmtIfThen(NodeBoolExpr boolexpr, NodeStmt stmt) {
        super(null, null);
        this.boolexpr = boolexpr;
        this.stmt = stmt;
    }

    public double eval(Environment env) throws EvalException {
        if (boolexpr.eval(env) != 0) {
            return stmt.eval(env);
        } else {
            return 0;
        }
    }

}
