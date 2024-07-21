import java.util.Scanner;

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

    public void addData(int data) {
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

    public void removeDuplicates() {
        Node save = first;

        while (save != null) {
            Node pred = save;
            while (pred.link != null) {
                if (pred.link.info == save.info) {
                    pred.link = pred.link.link;
                } else {
                    pred = pred.link;
                }
            }
            save = save.link;
        }
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class Lab62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("Enter the number of elements you want to add to the list:");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.addData(data);
        }

        System.out.println("Original List:");
        list.printList();

        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.printList();
        
        sc.close();
    }
} 