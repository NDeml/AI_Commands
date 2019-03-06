package Commands;

/**
 * Created by Nathaniel on 11/3/2017.
 */
public class AddCmd extends MathCommand {
    @Override
    public String doAction(Number n1, Number n2) {
        return n1.doubleValue() + n2.doubleValue() + "";
    }

    @Override
    public String doAction(Object o1, Object o2) {
        return this.doAction((Number) o1, (Number) o2);
    }

    @Override
    public String getCmdName() {
        return "addCmd";
    }
}
