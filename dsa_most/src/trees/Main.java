package trees;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*BinarySearchTree searchTree  = new BinarySearchTree();
        searchTree.insert(new Node(7));
        searchTree.insert(new Node(9));
        searchTree.insert(new Node(3));
        searchTree.insert(new Node(11));
        searchTree.insert(new Node(10));
        searchTree.insert(new Node(6));

        searchTree.display();
        System.out.println(searchTree.search(22));*/
        Map<String, String> costPrinter = new HashMap<>();
        costPrinter.put ("HP101", "$195");

        costPrinter.put("HP203", "$204");

        costPrinter.put("HP101", "$159");

        System.out.println(costPrinter.size());
    }
}
