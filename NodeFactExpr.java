//This class represents a NodeFact Expr
//Extends NodeFact
public class NodeFactExpr extends NodeFact {

	private NodeExpr expr;

	/**
	 Creates a new instance of {@code NodeFactExpr} with the specified expression.
	 @param expr the expression associated with this fact
	 */
	public NodeFactExpr(NodeExpr expr) {
		this.expr=expr;
	}

	/**
	 Evaluates the expression associated with this fact using the specified environment.
	 @param env the environment to use for evaluation
	 @return the result of evaluating the expression
	 @throws EvalException if an error occurs during evaluation
	 */
	public double eval(Environment env) throws EvalException {
		return expr.eval(env);
	}

	/**
	 Generates the code for this fact expression.
	 @return the code for this fact expression
	 */

	public String code() { return "("+expr.code()+")"; }

}
