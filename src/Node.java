public class Node {

    private int element, height;
    private Node lefthild, rightChild;

    public Node() {}

    public Node(int element){
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLefthild() {
        return lefthild;
    }

    public void setLefthild(Node lefthild) {
        this.lefthild = lefthild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
