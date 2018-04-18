/**
 * Created by ZY on 15.04.18.
 */
public class Command {

    private String [] commandTokens;
    private String command;
    private String key;
    private int points;
    private Trie trie;
    private boolean valid;


    public Command(String commandString, Trie trie){
        this.commandTokens = commandString.trim().split("\\s+");
        this.trie = trie;

        switch (commandTokens.length){
            case 1:
                this.command = commandTokens[0].toLowerCase();
                if ( "new trie help quit".contains(command) ) this.valid = true;
                else this.valid = false;
                break;
            case 2:
                this.command = commandTokens[0].toLowerCase();
                this.key = commandTokens[1].toLowerCase();
                if ("delete points".contains(command)) this.valid = true;
                else this.valid = false;
                break;
            case 3:
                this.command = commandTokens[0].toLowerCase();
                this.key = commandTokens[1].toLowerCase();
                this.points = Integer.parseInt(commandTokens[2].toLowerCase());
                if ("add change".contains(command)) this.valid = true;
                else this.valid = false;
                break;
            default:
                this.valid = false;
        }
    }

    public void execute(){
        if ( this.valid ){
            switch(this.command) {
                case "help":
                    this.trie.help(); break;
                case "quit":
                    this.trie.quit(); break;
                case "trie":
                    System.out.print(this.trie.toString()); break;
                case "new":
                    this.trie.newTrie(); break;
                case "add":
                    this.trie.add(this.key, this.points); break;
                case "change":
                    this.trie.change(this.key, this.points); break;
                case "delete":
                    this.trie.delete(this.key); break;
                case "points":
                    this.trie.getPoints(this.key); break;
                default:
                    this.invalidCommand();
            }
        } else this.invalidCommand();
    }

    private void invalidCommand(){
        System.out.print("ERROR! Invalid command syntax. Use HELP.\n");
    }


}
