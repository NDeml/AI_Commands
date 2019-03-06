package Commands;

/**
 * Created by Nathaniel on 11/4/2017.
 */
public class CommandNullException extends Exception {
    public CommandNullException(String cmdValue){
        super();
        System.out.println("Command is null. Expected command was " + cmdValue);
    }
}
