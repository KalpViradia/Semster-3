import java.util.*;

class Node {
    int info;
    Node link;

    Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class SinglyLinkedList {
    Node first;

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

    public boolean isSame(SinglyLinkedList list2) {
        Node temp1 = this.first;
        Node temp2 = list2.first;

        while (temp1 != null && temp2 != null) {
            if (temp1.info != temp2.info) {
                return false;
            }
            temp1 = temp1.link;
            temp2 = temp2.link;
        }

        return temp1 == null && temp2 == null;
    }

    public void display() {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println("null");
    }
}

public class Lab59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        System.out.println("Enter elements for the first linked list (type -1 to end):");
        while (true) {
            int info = sc.nextInt();
            if (info == -1) {
                break;
            }
            list1.insertAtEnd(info);
        }

        System.out.println("Enter elements for the second linked list (type -1 to end):");
        while (true) {
            int info = sc.nextInt();
            if (info == -1) {
                break;
            }
            list2.insertAtEnd(info);
        }

        System.out.print("List 1: ");
        list1.display();

        System.out.print("List 2: ");
        list2.display();

        boolean areSame = list1.isSame(list2);
        if (areSame) {
            System.out.println("The lists are the same.");
        } else {
            System.out.println("The lists are not the same.");
        }

        sc.close();
    }
}