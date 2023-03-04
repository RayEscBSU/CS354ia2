public class NodeWr extends Node {

	private NodeExpr expr;

	public NodeWr(NodeExpr expr) {
		this.expr=expr;
	}

	public double eval(Environment env) throws EvalException {
		double d=expr.eval(env);
		double i=d;
		if (i==d)
			System.out.println((int)i);
		else
			System.out.println(d);
		return d;
	}

	public String code() {
		return "printf(\"%g\\n\","
			+"(double)("
			+expr.code()
			+"));";
	}

}
