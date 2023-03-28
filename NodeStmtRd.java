public class NodeStmtRd extends NodeStmt{

    //Store scanner as a static variable
    static Scanner s = null;

    /**
     * Constructs a statement node with the specified assignment node.
     *
     * @param assn the assignment node
     */
    public NodeStmtRd(NodeAssn assn) {
        super(assn);
    }

}
