//This class represents a node term
public class NodeTerm extends Node {

	private NodeFact fact;
	private NodeMulop mulop;
	private NodeTerm term;

	/**
	 Constructs a new NodeTerm with the given fact, mulop, and term nodes.
	 @param fact the NodeFact representing the factor expression in the term
	 @param mulop the NodeMulop representing the multiplication or division operator in the term
	 @param term the NodeTerm representing the next term expression in the series, if any
	 */
	public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
		this.fact=fact;
		this.mulop=mulop;
		this.term=term;
	}

	/**
	 Appends a new NodeTerm to the end of this NodeTerm's term sequence.
	 @param term the NodeTerm to append
	 */
	public void append(NodeTerm term) {
		if (this.term==null) {
			this.mulop=term.mulop;
			this.term=term;
			term.mulop=null;
		} else
			this.term.append(term);
	}

	/**
	 Evaluates the value of this NodeTerm expression in the given environment.
	 @param env the Environment in which to evaluate the expression
	 @return the result of the evaluation
	 @throws EvalException if there is an error evaluating the expression
	 */
	public double eval(Environment env) throws EvalException {
		return term==null
			? fact.eval(env)
			: mulop.op(term.eval(env),fact.eval(env));
	}

	/**
	 Generates a code string representing this NodeTerm and its children.
	 @return the code string representing this NodeTerm
	 */
	public String code() {
		return (term==null ? "" : term.code()+mulop.code())+fact.code();
	}

}
