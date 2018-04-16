/**
 * Created by ZY on 15.04.18.
 */
public class Node {

    private int points = -1;
    private Node [] children = new Node [26];
    private char ch;
    private Node parent;


    public Node() {
    }

    public Node(char ch, Node parent){
        this.ch = ch;
        this.parent = parent;
        int charIndex = (int) ch - 97;
        parent.children[charIndex] = this;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Node[] getChildren() {
        return this.children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public void setChild(char ch, Node child){
        int childIndex = (int) ch - 97;
        this.children[childIndex] = child;
    }

    public Node find (char childChar){
        boolean childCharFound = false;
        int i = 0;
        while ( !childCharFound || i == children.length -1 ) {
            if (children[i].ch == childChar) {
                return children[i];
            } else i++;
        }
        return null;
    }

    public void find(Node node){

    }
    public void delete (Node nodeToDelete){

    }

    @Override
    public String toString() {

        String pointsPart = "";
        String nodePart;
        String childrenPart = "";

        // build node name part
        if (this.parent == null){
            nodePart = "+";
        } else nodePart = Character.toString(this.ch) ;

        // build points part. If not empty, put square brackets around
        if ( this.points > -1 ) pointsPart = "[" + String.valueOf(this.points) + "]";

        // recursively build children string.
        for (int i = 0; i < this.children.length; i++) {
            if ( this.children[i] != null ) {
                childrenPart = childrenPart + this.children[i].toString();
            }
        }

        // if children string not empty, put brackets around
        if (childrenPart != "" ){
            childrenPart = "(" + childrenPart + ")";
        }

        return nodePart + pointsPart + childrenPart;
    }
}
