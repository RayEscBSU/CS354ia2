// This class represents an assignment statement
public class NodeAssn extends Node {

	private String id;
	private NodeExpr expr;

	/**
	 Constructs an instance of NodeAssn with the given identifier and expression.
	 @param id The identifier for the variable being assigned.
	 @param expr The expression whose value will be assigned to the variable.
	 */
	public NodeAssn(String id, NodeExpr expr) {
		this.id = id;
		this.expr = expr;
	}

	/**
	 Evaluates this node by assigning the value of its expression to the corresponding variable
	 in the given environment.
	 @param env The environment in which the variable is defined.
	 @return The value of the expression that was assigned to the variable.
	 @throws EvalException If there was an error evaluating the expression or assigning the value.
	 */
	public double eval(Environment env) throws EvalException {
		return env.put(id, new NodeWr(expr).eval(env));
	}

	/**
	 Returns the code representation of this node and its expression.
	 @return The code representation of this node and its expression.
	 */
	public String code() {
		return id + "=" + expr.code() + ";" + new NodeWr(expr).code();
	}

}
