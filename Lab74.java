class CircularLinkedList1 {
    class Node {
        int info;
        Node link;

        Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    Node first;

    public void insert(int data) {
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

    public void splitCircularList() {
        if (first == null) return;
        Node slow = first;
        Node fast = first;
        while (fast.link != first && fast.link.link != first) {
            slow = slow.link;
            fast = fast.link.link;
        }
        if (fast.link.link == first) {
            fast = fast.link;
        }
        Node head1 = first;
        Node head2 = slow.link;
        slow.link = head1;
        fast.link = head2;
        display(head1, "First half:");
        display(head2, "Second half:");
    }

    private void display(Node node, String message) {
        System.out.println(message);
        Node temp = node;
        if (node != null) {
            do {
                System.out.print(temp.info + " ");
                temp = temp.link;
            } while (temp != node);
        }
        System.out.println();
    }
}

public class Lab74 {
    public static void main(String[] args) {
        CircularLinkedList1 cll = new CircularLinkedList1();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);
        cll.insert(6);

        cll.splitCircularList();
    }
}