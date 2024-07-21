import java.util.*;

class Node {
    int info;
    Node link;
    public Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class methodForSort {
    Node first;
    public void add(int data) {
        Node newNode = new Node(data);
        if(first == null) {
            first = newNode;
        }
        else {
            Node temp = first;
            while(temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void display() {
        Node temp = first;
        while(temp != null) {
            System.out.print(temp.info+" ");
            temp = temp.link;
        }
    }

    Node getMiddle(Node first) {
        if(first == null) {
            return first;
        }
        Node slow = first;
        Node fast = first.link;
        while(fast != null && fast.link != null) {
            slow = slow.link;
            fast = fast.link.link;
        }
        return slow;
    }

    Node merge(Node left, Node right) {
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        Node result;
        if(left.info <= right.info) {
            result = left;
            result.link = merge(left.link, right);
        }
        else {
            result = right;
            result.link = merge(left, right.link);
        }
        return result;
    }

    Node sort(Node first) {
        if(first == null || first.link == null) {
            return first;
        }
        Node middle = getMiddle(first);
        Node nextmiddle = middle.link;
        middle.link = null;
        Node left = sort(first);
        Node right = sort(nextmiddle); 
        return merge(left, right);
    }

    public void Sort() {
        first = sort(first);
    }
}

public class Lab65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        methodForSort Sort = new methodForSort();
        System.out.println("Enter size of the list: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Enter value for index "+i+": ");
            int data = sc.nextInt();
            Sort.add(data);
        }
        Sort.Sort();
        System.out.println("Sorted List is: ");
        Sort.display();
        sc.close();
    }
}