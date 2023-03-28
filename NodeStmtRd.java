public class NodeStmtRd extends NodeStmt{

    //Store scanner as a static variable
    static Scanner s = null;
    //check if scanner is null and if so, create a new scanner
    // if not, use the same scanner, do not use more than one scanner

    /**
     * Constructs a statement node with the specified assignment node.
     *
     * @param assn the assignment node
     */
    public NodeStmtRd(NodeAssn assn) {
        super(assn);
    }

}
