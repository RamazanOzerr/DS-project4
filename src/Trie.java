public class Trie {

    private Node root;

    public class Node{

        private char c;
        private boolean isWord;
        private Node[] children;

        public Node(char c){
            this.c = c;
            isWord = false;
            children = new Node[26];  // alfabede 26 harf olduğu için
        }
    }


    public Trie(){
        // root u zaten kullanmayacağımız için karakterin ne olduğunun bir önemi yok
        root = new Node('\0');
    }

    public void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i); // eğer o karakter e ait node yoksa, oluşturuyoruz
            int index = c - 'a';
            if(curr.children[index] == null) { // şimdi 'a' nın zaten decimal bir değeri var, eğer biz c den 'a' yı
                curr.children[index] = new Node(c); // çıkarırsak index elde etmiş oluruz
                curr = curr.children[index];
            }curr.isWord = true;
        }
    }

    // hoca sadece insert istemişti ama ben yine de diğer methodları da yazıyorum

    //  parametre girilen kelime var mı diye bakar, varsa rue yoksa false döner
    public boolean search(String word){
        return getNode(word) != null && getNode(word).isWord;
    }

    //  parametre girilen hece var mı diye bakar, varsa rue yoksa false döner
    public boolean startsWith(String prefix){
        return getNode(prefix) != null;
    }

    // helper method for search
    private Node getNode(String word){
        Node curr = root;
        for(int i =0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(curr.children[index] == null) // eğer o karektere ait node oluşmamışsa demek ki o karakter mevcut değildir
                return null; // dolayısıyla word de mevcut değildir
            curr = curr.children[index]; // loop through the word
        }return curr;

    }

}
