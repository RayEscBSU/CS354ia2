public class NodeBoolExpr extends Node {

    private NodeExpr left;
    private NodeRelop relop;
    private NodeExpr right;

    public NodeBoolExpr(NodeExpr left, NodeRelop relop, NodeExpr right) {
        this.left = left;
        this.relop = relop;
        this.right = right;
    }

    @Override
    public double eval(Environment env) throws EvalException {
        double leftValue = left.eval(env);
        double rightValue = right.eval(env);
        boolean result;
        switch (relop.getOp()) {
            case "<":
                result = leftValue < rightValue;
                break;
            case "<=":
                result = leftValue <= rightValue;
                break;
            case ">":
                result = leftValue > rightValue;
                break;
            case ">=":
                result = leftValue >= rightValue;
                break;
            case "<>":
                result = leftValue != rightValue;
                break;
            case "==":
                result = leftValue == rightValue;
                break;
            default:
                throw new EvalException("Unknown relop: " + relop.getOp());
        }
        return result ? 1 : 0;
    }

    @Override
    public String toString() {
        return left + " " + relop + " " + right;
    }
}
