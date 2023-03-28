public class NodeRelop extends Node {

    private String relop;

    public NodeRelop(int pos, String relop) {
        this.pos = pos;
        this.relop = relop;
    }

    public String getRelop() {
        return relop;
    }
}
