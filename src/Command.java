/**
 * Created by ZY on 15.04.18.
 */
public class Command {

    private String commandString;
    private String [] commandTokens;
    private String command;
    private String key;
    private String value;


    public Command(String commandString){
        this.commandString = commandString;
    }

    public void runCommand(){

        this.commandTokens = this.commandString.trim().split("\\s+");
        switch (commandTokens.length){
            case 1:
                command = commandTokens[0].toLowerCase();
                if ( "new trie help quit".contains(command) ) {
                    this.execute(command);
                } else invalidCommand();
                break;
            case 2:
                command = commandTokens[0].toLowerCase();
                key = commandTokens[1].toLowerCase();
                if ("delete points".contains(command)) {
                    this.execute(command, key);
                } else invalidCommand();
                break;
            case 3:
                command = commandTokens[0].toLowerCase();
                key = commandTokens[1].toLowerCase();
                value = commandTokens[2].toLowerCase();
                if ("add change".contains(command)) {
                    this.execute(command, key, value);
                } else invalidCommand();
                break;
            default:
                this.invalidCommand();
        }
    }


    private void execute(String cmd){
        System.out.print("executing " + cmd + "\n" );
    }

    private void execute(String cmd, String key){
        System.out.print("executing " + cmd + " " + key + "\n" );
    }

    private void execute(String cmd, String key, String value){
        System.out.print("executing " + cmd + " " + key + " " + value+ "\n" );
    }

    private void invalidCommand(){
        System.out.print("ERROR! Invalid command syntax. Use HELP.\n");
    }


}
