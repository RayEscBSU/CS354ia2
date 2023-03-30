import java.util.Scanner;

// This class represents a node for a read operation
// extends Node
public class NodeRd extends Node {

    private String id;
    private static Scanner scanner;

    /**
     * Constructs a read operation node with the specified assignment node.
     *
     * @param id the assignment node for the read operation
     */
    public NodeRd(String id) {
        this.id = id;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Evaluates the read operation by reading input and performing the assignment.
     *
     * @param env the environment in which to evaluate the read operation
     * @return the result of the assignment
     * @throws EvalException if an error occurs during evaluation
     */
    public double eval(Environment env) throws EvalException {
        double inputValue = scanner.nextDouble();
        env.put(id, inputValue);  // put the input value into the environment
        return 0.0; // return 0.0 as the result of the read operation
    }

    /**
     * Returns the code represented by the read operation node as a string.
     *
     * @return the code represented by the read operation node
     */
    public String code() {
        return "read " + id;   // return the code for the read operation
    }

}