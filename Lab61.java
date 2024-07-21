import java.util.*;

class Node {
    int info;
    Node link;

    public Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class Queue {
    Node first,last;

    public void push(int data) {
        Node newNode = new Node(data);
        if(this.last == null) {
            this.first = this.last = newNode;
            return;
        }
        this.last.link = newNode;
        this.last = newNode;
    }

    public int pop() {
        if(this.first == null) {
            System.out.println("Queue Underflow");
            return -1;
        }
        Node temp = this.first;
        this.first = this.first.link;
        if(this.first == null) {
            this.last = null;
        }
        return temp.info;
    }

    public int peep() {
        if(this.first == null) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return this.first.info;
    }

    public void display() {
        if(this.first == null) {
            System.out.println("Queue Underflow");
            return;
        }
        Node temp = this.first;
        while(temp != null) {
            System.out.println(temp.info);
            temp = temp.link;
        }
    }
}

public class Lab61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        Queue queue = new Queue();
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. DISPLAY");
            System.out.println("4. PEEP");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    queue.push(value);
                    break;
                case 2:
                    queue.pop();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    queue.peep();
                    break;
                case 5:
                    System.out.println("Exiting");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}