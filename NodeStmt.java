//This class represents a node statment
// extends node
public class NodeStmt extends Node {

	private NodeAssn assn;

	/**
	 Constructs a statement node with the specified assignment node.
	 @param assn the assignment node
	 */
	public NodeStmt(NodeAssn assn) {
		this.assn=assn;
	}

	/**
	 Evaluates the statement by evaluating the assignment node contained within it.
	 @param env the environment in which to evaluate the statement
	 @return the result of evaluating the assignment node
	 @throws EvalException if an error occurs during evaluation
	 */
	public double eval(Environment env) throws EvalException {
		return assn.eval(env);
	}

	/**
	 Returns the code represented by the statement node as a string.
	 @return the code represented by the statement node
	 */
	public String code() { return assn.code(); }

}
