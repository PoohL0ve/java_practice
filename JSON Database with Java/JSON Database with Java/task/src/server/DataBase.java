package client;

public class DataBase {
    private String[] phrase = new String[100];

    public String setPhrase(int position, String word) {
        if (position <= 100 && position > 0) {
            if (phrase[position] == null) {
                phrase[position] = word;
                return "OK";
            } else { return "ERROR";}
        }
        return "ERROR";
    }
}
