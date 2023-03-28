public class NodeBoolExpr extends Node {

    private final NodeExpr left;
    private final NodeRelop relop;
    private final NodeExpr right;

    public NodeBoolExpr(NodeExpr left, NodeRelop relop, NodeExpr right) {
        this.left = left;
        this.relop = relop;
        this.right = right;
    }

    public double eval(Environment env) throws EvalException{
        return relop.op(left.eval(env), right.eval(env));
    }

    @Override
    public String toString() {
        return left + " " + relop + " " + right;
    }
}
