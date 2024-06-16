package lists;
import java.util.*;

public class CircularList {
    public int size = 0;
    public Nodes head = null;
    public Nodes tail = null;  // these are objects

    /**
     * Displays the objects in the circular linked list
     */
    public void print() {
        System.out.println("Objects of the Circular Linked List: ");
        Nodes holding = head;

        do {
            System.out.print(holding.element + " ");
            holding = holding.next;
        } while (holding != head);
        System.out.println();  // for space
    }

    /**
     * Add an object to the head of the linked-list
     * @param element
     */
    public void addNodeToHead(int element){
        Nodes n = new Nodes(element);
        if(size == 0) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            Nodes temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }

    /**
     * Ad an object to the tail of the circular object. If the
     * size of the item is 0, then the object is added to the head instead
     * @param element
     */
    public void addNodeToTail(int element) {
        Nodes newTail = new Nodes(element);

        if (size == 0) {
            addNodeToHead(element);
        } else {
            tail.next = newTail;
            tail = newTail;
            tail.next = head;
            size++;
        }
    }

    public void roundRobin() {
        System.out.println("Rotating the item");
        tail = head;
        head = head.next;
    }


    public void deleteNodeFromTail() {
        System.out.println("Deleting the Node: " + tail.element);

        if(tail.next == tail) {
            tail = null;
        }
        Nodes newTail = tail;

        while(newTail.next != tail) {
            newTail = newTail.next;
        }
        newTail.next = tail.next;
        tail = newTail;
    }

    public void deleteNodeFromHead() {
        head = head.next;
        tail = head;
        size--;
    }
}
