public class AVLTree {

    private Node root;

    public AVLTree() {}

    public void insert(int element){

        root = insert(element, root);

    }

    // insert method
    private Node insert(int element, Node node){

        //check whether the node is null or not
        if(node == null){
            node = new Node(element);
        }else if(element < node.getElement()){ // adding left child

            node.setLefthild(insert(element, node.getLefthild()));

            if(getHeight(node.getRightChild())  - getHeight(node.getLefthild()) == 2 )
                if( element > node.getRightChild().getElement())
                    node = rotateWithRightChild( node );
                else
                    node = doubleWithRightChild( node );
        }
        else if( element > node.getElement() ){ // adding right child

            node.setRightChild(insert(element, node.getRightChild()));

            if( getHeight(node.getRightChild()) - getHeight(node.getLefthild()) == 2 )
                if( element > node.getRightChild().getElement())
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
        }


             // if the element is already present in the tree, we will do nothing
        node.setHeight(getMaxHeight(getHeight(node.getLefthild()), getHeight(node.getRightChild())) + 1);

        return node;


    }

   private Node doubleWithRightChild(Node node){

        node.setRightChild(rotateWithLeftChild(node.getRightChild()));
        return rotateWithRightChild(node);

   }

    // creating rotateWithLeftChild() method to perform rotation of binary tree node with left child
    private Node rotateWithLeftChild(Node node2)
    {
        Node node1 = node2.getLefthild();
        node2.setLefthild(node1.getRightChild());
        node1.setRightChild(node2);
        node2.setHeight(getMaxHeight(getHeight(node2.getLefthild()), getHeight(node2.getRightChild())) + 1);
        node1.setHeight(getMaxHeight(getHeight(node1.getLefthild()), getHeight(node2)) + 1);
        return node1;
    }


    // creating rotateWithRightChild() method to perform rotation of binary tree node with right child
    private Node rotateWithRightChild(Node node1)
    {
        Node node2 = node1.getRightChild();
        node1.setRightChild(node2.getLefthild());
        node2.setLefthild(node1);
        node1.setHeight(getMaxHeight(getHeight(node1.getLefthild()), getHeight(node1.getRightChild())));
        node2.setHeight(getMaxHeight(getHeight(node2.getRightChild()), getHeight(node1)) + 1);
        return node2;

    }

    // return the max value in given parameters
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight){

        if(leftNodeHeight > rightNodeHeight){
            return leftNodeHeight;
        }else {
            return rightNodeHeight;
        }
    }

    // eğer node.getChild.getHeight şeklindeki bir kullanımda, child ın null olması durumunda hata alacağımız için
    // böyle bir method yazma gereği duyduk, null mı diye kontrol ediyoruz, null ise -1 değilse normal değerini dönüyor
    private int getHeight(Node node){

        if(node == null)
            return -1;
        else
            return node.getHeight();

    }


    // bu methdou debug için yazıyoruz hoca istemedi

    public void inorderTraversal() {inorderTraversal(root);}
    private void inorderTraversal(Node head) {
        if (head != null)
        {
            inorderTraversal(head.getLefthild());
            System.out.println(head.getElement()+"  "+head.getHeight());
            inorderTraversal(head.getRightChild());
        }
    }

    public void postorderTraversel(){ postorderTraversel(root);}
    private void postorderTraversel(Node head){

        if(head != null){
            postorderTraversel(head.getLefthild());
            postorderTraversel(head.getRightChild());
            System.out.println(head.getElement()+" ");
        }
    }

    public void preOrderTraversel() { preOrderTravesel(root); }
    private void preOrderTravesel(Node head){

        if(head != null){

            System.out.println(head.getElement()+" ");
            preOrderTravesel(head.getLefthild());
            preOrderTravesel(head.getRightChild());

        }
    }


}
