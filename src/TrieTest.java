/**
 * Created by ZY on 16.04.18.
 */
public class TrieTest {
    public static void main(String [] args){
        Trie t = new Trie();
        t.add("hans", 5);
        t.add("lea", 22);
        t.add("leon", 8);
        t.add("paul", 20);
        System.out.print(t.root.toString() + "\n");
        System.out.print("points von hans: " +t.getPoints("hans") + "\n");
    // System.out.print(t.getPoints("lena") + "\n");
        t.change("hans", 6);
        System.out.print(t.root.toString() + "\n");

    }
}
