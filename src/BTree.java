public class BTree {

    private int t;
    Node1 root;

    public BTree(int t){
        this.t = t;
        root = new Node1(t);


    }

    private Node1 Search(Node1 x, int key){

        int i = 0;
        if(x == null){
            return x;
        }
        for (i = 0; i<x.getKey().length; i++){
            if(key < x.getKey()[i]){
                break;
            }
            if(key == x.getKey()[i]){
                return x;
            }
        }if(x.isLeaf()){
            return null;
        }else {
            return  Search(x.getChild()[i], key);
        }
    }


    private void Split(Node1 x, int pos, Node1 y){

        Node1 z = new Node1(t);
        for (int j = 0; j < t-1;j++){
            z.getKey()[j] = y.getKey()[j+t];
        }
        if(!y.isLeaf()){
            for(int j = 0; j<t;j++){
                z.setChild(y.getChild());
            }
        }
    }


}
