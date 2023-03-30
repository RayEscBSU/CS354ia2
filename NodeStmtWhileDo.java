// This class represents a node statement for a while-do loop
// extends NodeStmt
public class NodeStmtWhileDo extends NodeStmt {

    private NodeBoolExpr NodeBoolExpr;
    private NodeStmt NodeStmt;

    /**
     Constructs a statement node with the specified NodeBoolExpr and loop NodeStmt.
     @param NodeBoolExpr the loop NodeBoolExpr node
     @param NodeStmt the loop NodeStmt node
     */
    public NodeStmtWhileDo(NodeBoolExpr NodeBoolExpr, NodeStmt NodeStmt) {
        super(null, NodeBoolExpr, null, null, null);
        this.NodeBoolExpr = NodeBoolExpr;
        this.NodeStmt = NodeStmt;
    }

    /**
     Evaluates the while-do statement by evaluating the loop NodeBoolExpr and NodeStmt.
     @param env the environment in which to evaluate the statement
     @return the result of evaluating the last executed statement within the loop NodeStmt
     @throws EvalException if an error occurs during evaluation
     */
    @Override
    public double eval(Environment env) throws EvalException {
        double result = 0;

        while (NodeBoolExpr.eval(env) == 1.0) {
            result = NodeStmt.eval(env);
        }

        return result;
    }

    /**
     Returns the code represented by the while-do statement node as a string.
     @return the code represented by the while-do statement node
     */
    @Override
    public String code() {
        return "while (" + NodeBoolExpr.code() + ") do " + NodeStmt.code();
    }
}
