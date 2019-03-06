package Commands;

/**
 * Created by Nathaniel on 11/4/2017.
 */
public interface Command {
    String doAction(Object o1, Object o2);
    String getCmdName();
}
