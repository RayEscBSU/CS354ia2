//This class represents a node fact number
public class NodeFactNum extends NodeFact {

	private String num;

	/**
	 Constructs a NodeFactNum object with the given numeric value.
	 @param num the numeric value to be represented by the node
	 */
	public NodeFactNum(String num) {
		this.num=num;
	}

	/**
	 Evaluates the numeric node with the given environment.
	 @param env the environment used for evaluation
	 @return the evaluated double value of the node
	 @throws EvalException if there is an error during evaluation
	 */
	public double eval(Environment env) throws EvalException {
		return Double.parseDouble(num);
	}

	/**
	 Returns the code representation of the numeric node.
	 @return the code representation of the node as a string
	 */
	public String code() { return num; }

}
