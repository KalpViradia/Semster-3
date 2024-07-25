import java.util.Scanner;

class CircularLinkedListMethod {
    class Node {
        int info;
        Node link;

        Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    Node first, last;

    CircularLinkedListMethod() {
        first = last = null;
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = last = newNode;
            last.link = first;
        } else {
            newNode.link = first;
            first = newNode;
            last.link = first;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            first = last = newNode;
            last.link = first;
        } else {
            newNode.link = last.link;
            last.link = newNode;
            last = newNode;
        }
    }

    public void deleteFromPosition(int position) {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = first;
        if (position == 1) {
            if (first == last) {
                first = last = null;
            } else {
                first = first.link;
                last.link = first;
            }
            return;
        }

        Node pred = null;
        for (int i = 1; temp != last && i < position; i++) {
            pred = temp;
            temp = temp.link;
        }

        if (temp == last) {
            if (temp == first) {
                first = last = null; 
            } else {
                pred.link = last.link;
                last = pred;
            }
        } else if (temp != null) {
            pred.link = temp.link;
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    public void display() {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = first;
        do {
            System.out.print(temp.info + " ");
            temp = temp.link;
        } while (temp != first);

        System.out.println();
    }
}

public class Lab71 {
    public static void main(String[] args) {
        CircularLinkedListMethod cll = new CircularLinkedListMethod();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front");
            System.out.println("2. Insert at end");
            System.out.println("3. Delete from position");
            System.out.println("4. Display all nodes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to insert at front: ");
                    data = sc.nextInt();
                    cll.insertAtFront(data);
                    break;

                case 2:
                    System.out.print("Enter the data to insert at end: ");
                    data = sc.nextInt();
                    cll.insertAtEnd(data);
                    break;

                case 3:
                    System.out.print("Enter the position to delete from: ");
                    position = sc.nextInt();
                    cll.deleteFromPosition(position);
                    break;

                case 4:
                    cll.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}