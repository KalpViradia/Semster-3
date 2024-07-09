import java.util.*;

class Node {
    int info;
    Node link;

    Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class CircularLinkedList {
    Node first;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            first.link = first;
            return;
        }
        Node temp = first;
        while (temp.link != first) {
            temp = temp.link;
        }
        temp.link = newNode;
        newNode.link = first;
    }

    public int countNodes() {
        if (first == null) {
            return 0;
        }
        Node temp = first;
        int count = 1;
        while (temp.link != first) {
            temp = temp.link;
            count++;
        }
        return count;
    }

    public void display() {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = first;
        do {
            System.out.print(temp.info + " -> ");
            temp = temp.link;
        } while (temp != first);
        System.out.println("(First)");
    }
}

public class Lab58 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at the end of the circular linked list");
            System.out.println("2. Display all nodes");
            System.out.println("3. Count the number of nodes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at end: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    int count = list.countNodes();
                    System.out.println("Number of nodes in the list: " + count);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}