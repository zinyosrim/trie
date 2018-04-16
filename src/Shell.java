/**
 * Created by ZY on 11.04.18.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public final class Shell {

    private Shell(){}

    public static void main ( String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        boolean quit = false;
        while (!quit) {
            System.out.print("trie> ");
            String input = stdin.readLine();
            if (input == null) {
                break;
            }

            Command command = new Command(input);
            command.runCommand();
        }
    }
}
