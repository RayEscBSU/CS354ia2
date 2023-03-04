//This class represents an expression
public class NodeExpr extends Node {

	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr expr;

	/**
	 Constructor for NodeExpr class.
	 @param term a term node in the expression
	 @param addop an add operator node in the expression
	 @param expr another expression node
	 */
	public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
		this.term=term;
		this.addop=addop;
		this.expr=expr;
	}

	/**
	 Append another expression node to this one.
	 @param expr the expression node to append
	 */
	public void append(NodeExpr expr) {
		if (this.expr==null) {
			this.addop=expr.addop;
			this.expr=expr;
			expr.addop=null;
		} else
			this.expr.append(expr);
	}

	/**
	 Evaluate the expression and return its value.
	 @param env the environment to use for evaluating variables
	 @return the value of the expression
	 @throws EvalException if there is an error evaluating the expression
	 */
	public double eval(Environment env) throws EvalException {
		return expr==null
			? term.eval(env)
			: addop.op(expr.eval(env),term.eval(env));
	}

	/**
	 Generate the code for the expression.
	 @return the code for the expression
	 */

	public String code() {
		return (expr==null ? "" : expr.code()+addop.code())+term.code();
	}

}
