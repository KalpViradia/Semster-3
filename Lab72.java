import java.util.Scanner;

class doubleNode {
    int info;
    doubleNode lpter;
    doubleNode rpter;

    public doubleNode(int data) {
        this.info = data;
        this.lpter = null;
        this.rpter = null;
    }
}

class DoublyLinkedList {
    doubleNode first;

    void insertAtFront(int data) {
        doubleNode newNode = new doubleNode(data);
        if (first == null) {
            first = newNode;
        } else {
            newNode.rpter = first;
            first.lpter = newNode;
            first = newNode;
        }
    }

    void deleteNode(int position) {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }

        doubleNode current = first;
        int count = 1;
        while (current != null && count < position) {
            current = current.rpter;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (current.lpter != null) {
            current.lpter.rpter = current.rpter;
        } else {
            first = current.rpter;
        }

        if (current.rpter != null) {
            current.rpter.lpter = current.lpter;
        }
    }

    void insertAtEnd(int data) {
        doubleNode newNode = new doubleNode(data);
        if (first == null) {
            first = newNode;
        } else {
            doubleNode current = first;
            while (current.rpter != null) {
                current = current.rpter;
            }
            current.rpter = newNode;
            newNode.lpter = current;
        }
    }

    void display() {
        doubleNode current = first;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.rpter;
        }
        System.out.println();
    }
}

public class Lab72 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front");
            System.out.println("2. Delete at position");
            System.out.println("3. Insert at end");
            System.out.println("4. Display all nodes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at front: ");
                    data = sc.nextInt();
                    list.insertAtFront(data);
                    break;
                case 2:
                    System.out.print("Enter position to delete: ");
                    position = sc.nextInt();
                    list.deleteNode(position);
                    break;
                case 3:
                    System.out.print("Enter data to insert at end: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 4:
                    System.out.print("Nodes in the list: ");
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}