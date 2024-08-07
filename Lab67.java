class Node {
    int info;
    Node link;

    Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class LinkedList {
    Node first;

    public void add(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public void insertGCDNodes() {
        Node current = first;

        while (current != null && current.link != null) {
            int gcdValue = gcd(current.info, current.link.info);
            Node gcdNode = new Node(gcdValue);
            
            gcdNode.link = current.link;
            current.link = gcdNode;
            current = gcdNode.link;
        }
    }
}

public class Lab67 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(12);
        list.add(15);
        list.add(21);
        list.add(30);

        System.out.println("Original List:");
        list.display();

        list.insertGCDNodes();

        System.out.println("List after inserting GCD nodes:");
        list.display();
    }
}