import java.util.List;

// This class represents a node for a block of statements
// extends Node
public class NodeBlock extends Node {

    private List<NodeStmt> stmtList;

    /**
     Constructs a block node with the specified list of statement nodes.
     @param stmtList the list of statement nodes
     */
    public NodeBlock(List<NodeStmt> stmtList) {
        this.stmtList = stmtList;
    }

    /**
     Evaluates the block by evaluating each statement in the block.
     @param env the environment in which to evaluate the block
     @return the result of evaluating the last statement in the block
     @throws EvalException if an error occurs during evaluation
     */
    public double eval(Environment env) throws EvalException {
        double result = 0;
        for (NodeStmt stmt : stmtList) {
            result = stmt.eval(env);
        }
        return result;
    }

    /**
     Returns the code represented by the block node as a string.
     @return the code represented by the block node
     */
    public String code() {
        StringBuilder code = new StringBuilder("{");
        for (NodeStmt stmt : stmtList) {
            code.append(stmt.code()).append("; ");
        }
        code.append("}");
        return code.toString();
    }
}
