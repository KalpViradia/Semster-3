import java.util.*;

public class Lab56 {

    static class Node {
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }

        public Node first = null;

        public void addData(int data) {
            Node newNode = new Node(data);
            if(first == null){
                first = newNode;
                return;
            }

            Node temp = first;
            first = newNode;
            first.link = temp;
        }

        public void printNode() {
            Node temp = first;
            System.out.print("Linklist is: ");
            while (temp != null) {
                System.out.print(temp.info + " ");
                temp = temp.link;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of node: ");
        int size = sc.nextInt();
        Node newNode = new Node(size);
        for (int i=0; i<5; i++) {
            System.out.println("Enter the value of node element: ");
            int data =sc.nextInt();
            newNode.addData(data);
        }
        newNode.printNode();
        sc.close();
    }
}