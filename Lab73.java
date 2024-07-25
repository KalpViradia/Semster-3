class DoublyLinkedList1 {
    class Node {
        int info;
        Node lpter;
        Node rpter;

        Node(int data) {
            this.info = data;
            this.lpter = null;
            this.rpter = null;
        }
    }

    Node first;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            return;
        }
        Node last = first;
        while (last.rpter != null) {
            last = last.rpter;
        }
        last.rpter = newNode;
        newNode.lpter = last;
    }

    public void deleteAlternateNodes() {
        if (first == null) return;
        Node current = first;
        int count = 0;

        while (current != null) {
            Node rpter = current.rpter;
            if (count % 2 != 0) {
                if (current.lpter != null) {
                    current.lpter.rpter = current.rpter;
                }
                if (current.rpter != null) {
                    current.rpter.lpter = current.lpter;
                }
            }
            current = rpter;
            count++;
        }
    }

    public void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.rpter;
        }
        System.out.println();
    }
}

public class Lab73 {
    public static void main(String[] args) {
        DoublyLinkedList1 dll = new DoublyLinkedList1();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(5);
        dll.insert(6);

        System.out.println("Original list:");
        dll.display();

        dll.deleteAlternateNodes();

        System.out.println("List after deleting alternate nodes:");
        dll.display();
    }
}