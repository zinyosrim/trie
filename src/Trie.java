/**
 * Created by ZY on 16.04.18.
 */
public class Trie {

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void newTrie(){
        this.root = new Node();
    }

    public boolean add(String key, Integer points) {

        Node node = this.root;

        // iterate the characters of key
        for (int i = 0; i < key.length(); i++) {

            int keyIndex = (int) key.charAt(i) - 97;
            Node childNode = node.getChildren()[keyIndex];

            // check if the char exists in the tree
            if (childNode == null) {    // node with character doesn't exist, so create it
                Node newChild = new Node(key.charAt(i), node);
                node = newChild;
            } else node = childNode;    // node exist, so go down from it to next level
        }

        // if the last node has no points, then set the points
        if (!(node.getPoints() > -1)) {
            node.setPoints(points);
            return true;
        } else return false;

    }

    public boolean delete(String key){
        return true;
    }

    public int getPoints(String key) {

        Node node = this.lastNode(key);
        if (node == null) return -1;
        else return node.getPoints();
    }

    public boolean change(String key, int newPoints) {

        Node node = this.lastNode(key);
        if (node == null) return false;
        else {
            node.setPoints(newPoints);
            return true;
        }
    }

    private Node lastNode(String key) {
        Node last = this.root;

        // iterate the characters of key
        for (int i = 0; i < key.length(); i++) {

            int keyIndex = (int) key.charAt(i) - 97;
            Node childNode = last.getChildren()[keyIndex];

            if (childNode == null) {     // node with character doesn't exist
                last = null;
            } else last = childNode;      // node exist, so go down from it to next level
        }
        return last;
    }

    public void help(){
        System.out.print("Valid commands are: HELP, NEW, TRIE, QUIT, ADD <key> <points>, CHANGE <key> <points>, DELETE <key>\n");
    }
    public void quit(){

    }
    public void trie(Trie trie){
        trie.toString();
    }



    @Override
    public String toString() {
        return this.root.toString() + "\n";
    }
}
