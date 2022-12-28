public class Node1 {

    private int n;
    private int[] key;
    private Node1[] child;
    private boolean leaf;

    public Node1(int t) {
//        this.n = n;
        this.key = new int[2*t - 1];
        this.child = new Node1[2 * t];
        this.leaf = true;
    }

    public int[] getKey() {
        return key;
    }

    public void setKey(int[] key) {
        this.key = key;
    }

    public Node1[] getChild() {
        return child;
    }

    public void setChild(Node1[] child) {
        this.child = child;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
