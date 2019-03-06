package StringParser;

import Commands.CmdManager;
import Commands.Command;

import java.util.ArrayList;


public class NaturalLanguageParser {
    public void parse(String string) {
        ArrayList<String> requests = new ArrayList<String>();
        String[] s1 = string.split("\\.");
        boolean lastValueNumber = false;

        for (int i = 0; i < s1.length; i++) {
            requests.add(s1[i]);
        }
        ArrayList commands = new ArrayList();

        for (int request = 0; request < requests.size(); request++) {
            String[] words = requests.get(request).split(" ");

            for (int i = 0; i < words.length; i++) {
                if(lastValueNumber){
                    lastValueNumber = false;
                    try {
                        String s = getFiller(words[i]);
                        if (!s.equals(null)) {
                            System.out.println("Filler added");
                            continue;
                        }
                    } catch (Exception e1) {}
                }

                try {
                    Integer value = getNumbers(words[i]);
                    if (!value.equals(null)) {
                        commands.add(value);
                        System.out.println("Number added");
//                        lastValueNumber = true;
                        continue;
                    }
                } catch (Exception ex) {}
                try {
                    String s = getAction(words[i]);
                    if (!s.equals(null)) {
                        System.out.println("Action added");
                        commands.add(s);
                        continue;
                    }
                } catch (Exception e1) {}
            }
            System.out.println(commands.toString());
            String answer = executeCommands(commands);
            System.out.println(answer);
        }
    }

    private String executeCommands(ArrayList commands) {
        String ans = "";
        CmdManager cm = new CmdManager();
        ArrayList list = commands;
        ArrayList<Number> numbers = new ArrayList<Number>();
        Command c = null;
        while(list.size() > 0){
            if(c != null && numbers.size() >= 2){
                ans += c.doAction(numbers.get(0), numbers.get(1)) + "\n";
            }
            try{
                if(c != null){
                    try {
                        c = cm.getCommand((String) list.get(0));
                        list.remove(0);
                        numbers = new ArrayList<Number>();
                        continue;
                    } catch (Exception e3){}
                }
                c = cm.getCommand((String) list.get(0));
                list.remove(0);
                continue;
            } catch (Exception e){}
            try{
                numbers.add((Number) list.get(0));
                list.remove(0);
                continue;
            } catch (Exception e2){}
        }
        if(c != null && numbers.size() >= 2){
            ans += c.doAction(numbers.get(0), numbers.get(1)) + "\n";
        }

        return ans;
    }

    private String getFiller(String word) {
        if(word.contains("apple")){
            return "apple";
        } else if (word.contains("orange")){
            return "orange";
        } else{
            return null;
        }
    }

    private String getAction(String word) {
        if (isAdd(word)) {
            return "addCmd";
        } else if (isSubtract(word)){
            return "subtractCmd";
        } else {
            return null;
        }
    }

    private boolean isAdd(String word) {
        if (word.toLowerCase().equals("add") || word.toLowerCase().equals("combine") || word.toLowerCase().equals("plus") || word.toLowerCase().equals("gets")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSubtract(String word) {
        if (word.equals("take") || word.equals("remove") || word.equals("subtract")) {
            return true;
        } else {
            return false;
        }
    }

    private Integer getNumbers(String word) {
        try {
            int value = Integer.valueOf(word);
            return value;
        } catch (Exception ex) {
            try {
                Integer value = getAlphaNumbers(word);
                return value;
            } catch (Exception e) {
                return null;
            }
        }
    }

    private Integer getAlphaNumbers(String word) {
        switch (word) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            default:
                return null;
        }
    }
}
