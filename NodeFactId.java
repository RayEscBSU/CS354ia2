//This class represents a Node fact identifier
//Extends NodeFact
public class NodeFactId extends NodeFact {

	private String id;

	/**
	 Constructs a NodeFactId with the specified position and identifier value.
	 @param pos the position in the source code
	 @param id the identifier value
	 */
	public NodeFactId(int pos, String id) {
		this.pos=pos;
		this.id=id;
	}

	/**
	 Evaluates the node by getting the value of the identifier from the given environment.
	 @param env the environment in which to evaluate the node
	 @return the value of the identifier
	 @throws EvalException if an error occurs during evaluation
	 */
	public double eval(Environment env) throws EvalException {
		return env.get(pos,id);
	}

	/**
	 Generates the code representation of the node as a string.
	 @return the code representation of the node
	 */
	public String code() { return id; }

}
