//This class represents a node statment
// extends node
public class NodeStmt extends Node {

	private NodeAssn assn;
	private NodeBoolExpr boolexpr;
	private NodeStmtIfThen nodeStmtIfThen;
	private NodeStmtIfThenElse nodeStmtIfThenElse;
	private NodeWhile nodeWhile;
	private NodeRd nodeRd;
	private NodeWr nodeWr;

	/**
	 Constructs a statement node with the specified assignment node.
	 @param assn the assignment node
	 */
	public NodeStmt(NodeAssn assn, NodeBoolExpr boolexpr, NodeStmtIfThen nodeStmtIfThen,
					NodeStmtIfThenElse nodeStmtIfThenElse, NodeWhile nodeWhile, NodeRd nodeRd, NodeWr nodeWr) {
		this.assn = assn;
		this.boolexpr = boolexpr;
		this.nodeStmtIfThen = nodeStmtIfThen;
		this.nodeStmtIfThenElse = nodeStmtIfThenElse;
		this.nodeWhile = nodeWhile;
		this.nodeRd = nodeRd;
		this.nodeWr = nodeWr;
	}

	public NodeStmt(NodeAssn assn, NodeBoolExpr boolexpr, NodeStmtIfThen nodeStmtIfThen) {
		this(assn, boolexpr, nodeStmtIfThen, null, null, null, null);
	}

	public NodeStmt(NodeAssn assn, NodeBoolExpr boolexpr) {
		this(assn, boolexpr, null,null,null, null, null);

	}


	/**
	 Evaluates the statement by evaluating the assignment node contained within it.
	 @param env the environment in which to evaluate the statement
	 @return the result of evaluating the assignment node
	 @throws EvalException if an error occurs during evaluation
	 */
	public double eval(Environment env) throws EvalException {
		if (assn != null) {
			return assn.eval(env);
		} else if (boolexpr != null) {
			return boolexpr.eval(env);
		} else if (nodeStmtIfThen != null) {
			return nodeStmtIfThen.eval(env);
		} else if (nodeStmtIfThenElse != null) {
			return nodeStmtIfThenElse.eval(env);
		} else if (nodeWhile != null) {
			return nodeWhile.eval(env);
		}else if(nodeRd !=null){
			return nodeRd.eval(env);
		} else if (nodeWr != null) {
			return nodeWr.eval(env);
		} else {
			throw new SyntaxException( pos(), + "No statement available for evaluation.");
		}
	}

	/**
	 Returns the code represented by the statement node as a string.
	 @return the code represented by the statement node
	 */
	public String code() {
		if (assn != null) {
			return assn.code();
		} else if (boolexpr != null) {
			return boolexpr.code();
		} else if (nodeStmtIfThen != null) {
			return nodeStmtIfThen.code();
		} else if (nodeStmtIfThenElse != null) {
			return nodeStmtIfThenElse.code();
		} else if (nodeWhile != null) {
			return nodeWhile.code();
		} else {
			return "";
		}
	}

}
