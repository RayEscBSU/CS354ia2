// This class represents a node for a while loop
// extends Node
public class NodeWhile extends Node {

    private NodeBoolExpr nodeBoolExpr;
    private NodeStmt nodeStmt;

    /**
     Constructs a while loop node with the specified nodeBoolExpr and loop nodeStmt.
     @param nodeBoolExpr the loop nodeBoolExpr node
     @param nodeStmt the loop nodeStmt node
     */
    public NodeWhile(NodeBoolExpr nodeBoolExpr, NodeStmt nodeStmt) {
        this.nodeBoolExpr = nodeBoolExpr;
        this.nodeStmt = nodeStmt;
    }

    /**
     Evaluates the while loop by evaluating the loop nodeBoolExpr and nodeStmt.
     @param env the environment in which to evaluate the loop
     @return the result of evaluating the last executed statement within the loop nodeStmt
     @throws EvalException if an error occurs during evaluation
     */
    public double eval(Environment env) throws EvalException {
        double result = 0;

        while (nodeBoolExpr.eval(env) != 0) {
            result = nodeStmt.eval(env);
        }

        return result;
    }

    /**
     Returns the code represented by the while loop node as a string.
     @return the code represented by the while loop node
     */
    public String code() {
        return "while (" + nodeBoolExpr.code() + ") { " + nodeStmt.code() + " }";
    }
}
