public class NodeRelop extends Node {

    private String relop;

    public NodeRelop(int pos, String relop) {
        this.pos = pos;
        this.relop = relop;
    }

    public String getRelop() {
        return relop;
    }

    public double op(double l, double r) throws EvalException {
        boolean result;
        switch (getRelop()) {
            case "<":
                result = l < r;
                break;
            case "<=":
                result = l <= r;
                break;
            case ">":
                result = l > r;
                break;
            case ">=":
                result = l >= r;
                break;
            case "<>":
                result = l != r;
                break;
            case "==":
                result = l == r;
                break;
            default:
                throw new EvalException(pos, "Unknown relop: " + relop);
        }
        return result ? 1:0;
    }
}
