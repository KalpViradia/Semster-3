import java.util.*;

class Node {
    int info;
    Node link;
    public Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class methodForReverse {
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

    public void reverse() {
        Node pred = null;
        Node save = first;
        Node link = null;
        while(save != null) {
            link = save.link;
            save.link = pred;
            pred = save;
            save = link;
        }
        first = pred;
    }

    public void display() {
        Node temp = first;
        while(temp != null) {
            System.out.print(temp.info+" ");
            temp = temp.link;
        }
    }
}

public class Lab64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        methodForReverse reverse = new methodForReverse();
        System.out.println("Enter size of the list: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Enter value for index "+i+": ");
            int data = sc.nextInt();
            reverse.add(data);
        }
        reverse.reverse();
        System.out.println("Reversed List is: ");
        reverse.display();
        sc.close();
    }   
}