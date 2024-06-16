package lists;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CircularList myList = new CircularList();
        myList.addNodeToHead(19);
        myList.addNodeToHead(35);
        myList.addNodeToHead(67);
        myList.print();

        myList.roundRobin();
        myList.print();
    }
}
