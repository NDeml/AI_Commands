import StringParser.NaturalLanguageParser;

/**
 * Created by Nathaniel on 11/3/2017.
 */
public class Suite {
    public static void main(String[] args){
        NaturalLanguageParser n = new NaturalLanguageParser();
        n.parse("John has two apples and gets 10 apples.");
    }
}
