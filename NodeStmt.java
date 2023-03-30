//This class represents a node statment
// extends node
public class NodeStmt extends Node {

	private NodeAssn assn;
	private NodeBoolExpr boolexpr;
	private NodeStmtIfThen nodeStmtIfThen;
	private NodeStmtIfThenElse nodeStmtIfThenElse;

	/**
	 Constructs a statement node with the specified assignment node.
	 @param assn the assignment node
	 */
	public NodeStmt(NodeAssn assn, NodeBoolExpr boolexpr, NodeStmtIfThen nodeStmtIfThen, NodeStmtIfThenElse nodeStmtIfThenElse) {
		this.assn = assn;
		this.boolexpr = boolexpr;
		this.nodeStmtIfThen = nodeStmtIfThen;
		this.nodeStmtIfThenElse = nodeStmtIfThenElse;
	}

	public NodeStmt(NodeAssn assn, NodeBoolExpr boolexpr, NodeStmtIfThen nodeStmtIfThen) {
		this(assn, boolexpr, nodeStmtIfThen, null);
	}

	public NodeStmt(NodeAssn assn, NodeBoolExpr boolexpr) {
		this(assn, boolexpr, null,null);

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
