package lists.doubly;

public class Main {
    //Node
    public static class Node {
        int data;
        Node next;
        Node prev;

        //constructor creates new node
        public Node(int data) {
            this.data = data;
        }
    }

    //DoubleLists
    public static class DoubleLists {
        Node head;

        public void addToHead(int element) {
            Node n = new Node(element);
            //the next of the one is now the head
            //make the previous node null
            n.next = head;
            n.prev = null;
            //previous of head is the new node
            if (head != null) {
                head.prev = n;
            }
            //move the head to point to new node
            head = n;
        }

        public void addToTail(int element) {
            // new node
            Node n = new Node(element);
            Node end = head;
            n.next = null;
            //if list is empty make new node the head
            if (head == null) {
                n.prev = null;
                head = n;
                return;
            }
            //go until you find the last
            while (end.next != null) {
                end = end.next;
            }
            //change next of the last node
            end.next = n;
            //make last node the previous of new node
            n.prev = end;
        }

        public void insertNode(Node prev, int element) {
            //is the given node null?
            if (prev == null) {
                System.out.println("Cannot have previous node of null");
                return;
            }
            //create new node and add data
            Node n = new Node(element);
            //make new node's next the next of the previous
            n.next = prev.next;
            //make next of prev the new node
            prev.next = n;
            //make previous node as previous of new node
            n.prev = prev;
            //change previous of new nodes next node
            if (n.next != null) {
                n.next.prev = n;
            }
        }

        public void printList(Node node) {
            System.out.println("Going forward --> ");
            Node end = null;
            while (node != null) {
                System.out.print(node.data + " ");
                end = node;
                node = node.next;
            }
            System.out.println();
            System.out.println("<-- Going backward ");
            while (end != null) {
                System.out.print(end.data + " ");
                end = end.prev;
            }
        }

    }
    // ***************************
    // ********** MAIN ***********
    // ***************************

    public static void main(String[] args) {
        //create the list
        DoubleLists dll = new DoubleLists();
        //add item to head
        dll.addToHead(50);
        //add item to tail
        //list is now 50 -> 100 -> NULL
        dll.addToTail(100);
        //add item to head
        //list is 25 -> 50 -> 100 -> NULL
        dll.addToHead(25);
        //insert 75 after 50;
        dll.insertNode(dll.head.next, 75);
        //print
        dll.printList(dll.head);

    }
}
