public class NodeFactNeg extends NodeFact {

	private NodeExpr fact;

	public NodeFactNeg(NodeExpr fact) {
		this.fact=fact;
	}

	public int eval(Environment env) throws EvalException {
		return -this.fact.eval(env);
	}

	public String code() { return "-" + this.fact.code(); }

}
