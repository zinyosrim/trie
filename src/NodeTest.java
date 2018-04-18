/**
 * Created by ZY on 16.04.18.
 */
public class NodeTest {
    public static void main(String [] args){
        Node root = new Node();
        Node h = new Node ('h', root);
        Node a = new Node ('a', h);
        Node n = new Node ('n', a);
        Node s = new Node ('s', n);
        Node l = new Node ('l', root);
        Node e = new Node ('e', l);
        Node a2 = new Node ('a', e);
        Node o = new Node ('o', e);
        Node n2 = new Node ('z', o);


        s.setPoints(5);
        a2.setPoints(22);
        n2.setPoints(8);
        System.out.print("tree: " + root.toString()+"\n");
        // a2.delete();
        // System.out.print("tree: " + root.toString()+"\n");
    }
}
