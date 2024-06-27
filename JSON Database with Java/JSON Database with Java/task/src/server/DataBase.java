package server;

public class DataBase {
    private static String[] phrase = new String[100];
    private int pos = 0;
    private String insert = "";

    public String setPhrase(int position, String word) {

        if (position <= 100 && position > 0) {
            if (phrase[position - 1] != null) {
                phrase[position - 1] = word;
                // String old = phrase[position - 1];
                //System.out.println("Old: " + old);
               // System.out.println("New: " + word);
                //phrase[position - 1] = phrase[position - 1].replace(old, word);
                //System.out.println("Stored: " + phrase[position - 1]);
                return "OK";
            }
            phrase[position - 1] = word;
            return "OK";
        }
        return "ERROR";
    }

    public void separate(String word) {
        String needed = word.substring(4);
        String[] divide = needed.split(" ");
        pos = Integer.parseInt(divide[0]);
        String check = "";

        for (int i = 1; i < divide.length; i++) {
            if (divide[i] != null && !divide[i].equals(" ")) {
                check += divide[i] + " ";
                /*if (!insert.isEmpty()) {
                    insert = " ";
                }
                insert += divide[i];*/

            }
        }
        insert = check;
        //System.out.println("Check: " + check);
        System.out.println(setPhrase(pos, insert));
    }

    public String getPhrase(String word) {
        String guess = word.substring(4);
        String[] search = guess.split(" ");
        int find = Integer.parseInt(search[0]);

        if (find <= 100 && find > 0) {
            if (phrase[find-1] == null || phrase[find-1].equals(" ")) {
                return "ERROR";
            } else {
                return phrase[find - 1];
            }
        } else {return "ERROR";}
    }

    public String delete(String word) {
        String sep = word.substring(7);
        String[] split = sep.split(" ");
        int search = Integer.parseInt(split[0]);

        try {
            if (search <= 100 && search > 0) {
                if (phrase[search - 1].isEmpty()) {
                    return "OK";
                } else {
                    phrase[search - 1] = " ";
                    return "OK";
                }
            } return "ERROR";
        } catch (NullPointerException e) {
            return ("OK");
        }

        //return "ERROR";
    }
}
