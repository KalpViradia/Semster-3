import java.util.*;

class Node {
    int info;
    Node link;

    public Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class SinglyLinkedList {
    Node first;

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.link = first;
        first = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            return;
        }
        Node temp = first;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = newNode;
    }

    public void deleteFirstNode() {
        if (first != null) {
            first = first.link;
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void deleteLastNode() {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (first.link == null) {
            first = null;
            return;
        }
        Node temp = first;
        while (temp.link.link != null) {
            temp = temp.link;
        }
        temp.link = null;
    }

    public void deleteNodeAtPosition(int position) {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (position == 0) {
            first = first.link;
            return;
        }
        Node temp = first;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.link;
        }
        if (temp == null || temp.link == null) {
            System.out.println("Position out of range.");
            return;
        }
        temp.link = temp.link.link;
    }

    public void display() {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = first;
        System.out.print("Linklist is: ");
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
    }
}

public class Lab57 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at the front of the linked list");
            System.out.println("2. Display all nodes");
            System.out.println("3. Delete the first node of the linked list");
            System.out.println("4. Insert a node at the end of the linked list");
            System.out.println("5. Delete the last node of the linked list");
            System.out.println("6. Delete a node from specified position");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at front: ");
                    data = sc.nextInt();
                    list.insertAtFront(data);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.deleteFirstNode();
                    break;
                case 4:
                    System.out.print("Enter data to insert at end: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 5:
                    list.deleteLastNode();
                    break;
                case 6:
                    System.out.print("Enter position to delete node (starting from 0): ");
                    position = sc.nextInt();
                    list.deleteNodeAtPosition(position);
                    break;
                case 7:
                    System.out.println("Exiting");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}