package Commands;

import java.util.ArrayList;

public class CmdManager {
    private static ArrayList<Command> cmds = new ArrayList<Command>();

    public CmdManager(){
        cmds.add(new AddCmd());
        cmds.add(new SubtractCmd());
    }

    public Command getCommand(String cmdValue) throws CommandNullException {
        Command c = null;
        for(int i = 0; i < cmds.size(); i++){
            String val = cmds.get(i).getCmdName().toLowerCase().trim();
            if(cmdValue.toLowerCase().trim().equals(val)){
                c = cmds.get(i);
            }
        }
        if(c==null){
            throw new CommandNullException(cmdValue);
        }
        return c;
    }
}
