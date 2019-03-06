package Commands;


public abstract class MathCommand implements Command{
    public abstract String doAction(Number n1, Number n2);
    public abstract String getCmdName();
}
