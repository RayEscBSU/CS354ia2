//This class represents a Nod Fact Negative operation
public class NodeFactNeg extends NodeFact {

	private NodeFact fact;

	/**
	 Constructs a NodeFactNeg object with the specified NodeFact.
	 @param fact the NodeFact to be negated
	 */
	public NodeFactNeg(NodeFact fact) {
		this.fact=fact;
	}

	/**
	 Evaluates the negation of the NodeFact.
	 @param env the environment containing variable bindings
	 @return the negation of the NodeFact's evaluation result
	 @throws EvalException if there is an error during evaluation
	 */
	public double eval(Environment env) throws EvalException {
		return -this.fact.eval(env);
	}

	/**
	 Returns the code representation of the negated NodeFact.
	 @return the code representation of the negated NodeFact
	 */
	public String code() { return "-" + this.fact.code(); }

}
