// AVL Treetest ettiğimiz main methodu
public class Main {

    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();

        avlTree.insert(1);
        avlTree.insert(7);
        avlTree.insert(35);
        avlTree.insert(10);
        avlTree.insert(8);
        avlTree.insert(14);
        avlTree.insert(31);
        avlTree.insert(46);
        avlTree.insert(22);
        avlTree.insert(92);
        avlTree.insert(85);
        avlTree.insert(43);
        avlTree.insert(2);
        avlTree.insert(11);
        avlTree.insert(3);


        avlTree.inorderTraversal();
    }
}
