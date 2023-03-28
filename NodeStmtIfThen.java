public class NodeStmtIfThen extends NodeStmt{
/**
     * Constructs a statement node with the specified assignment node.
     *
     * @param assn the assignment node
     */
    private NodeBoolExpr boolexpr;
    private Node stmt;

    public NodeStmtIfThen(NodeBoolExpr boolexpr, Node stmt) {
        this.boolexpr = boolexpr;
        this.stmt = stmt;
    }

    /**
     * Constructs a statement node with the specified assignment node.
     *
     * @param assn the assignment node
     */
    public NodeStmtIfThen(NodeAssn assn) {
        super(assn);
    }

    @Override
    public double eval(Environment env) throws EvalException {
        if (boolexpr.eval(env) != 0) {
            return stmt.eval(env);
        } else {
            return 0;
        }
    }

}
