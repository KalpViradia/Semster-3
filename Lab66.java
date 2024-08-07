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

    public void swapKthNodes(int k) {
        if (first == null || k <= 0) {
            return;
        }

        Node first = first;
        Node firstPrev = null;

        for (int i = 1; i < k; i++) {
            if (first == null) {
                return;
            }
            firstPrev = first;
            first = first.link;
        }

        Node second = first;
        Node secondPrev = null;
        Node temp = first;

        while (temp.link != null) {
            temp = temp.link;
            secondPrev = second;
            second = second.link;
        }

        if (first == second) {
            return;
        }

        if (firstPrev != null) {
            firstPrev.link = second;
        } else {
            first = second;
        }

        if (secondPrev != null) {
            secondPrev.link = first;
        } else {
            first = first;
        }

        Node tempNext = first.link;
        first.link = second.link;
        second.link = tempNext;
    }
}

public class Lab66 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original List:");
        list.display();

        int k = 2;
        list.swapKthNodes(k);

        System.out.println("List after swapping " + k + "th node from beginning with " + k + "th node from end:");
        list.display();
    }
}