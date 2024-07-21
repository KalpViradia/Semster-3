import java.util.*;

class Node {
    int info;
    Node link;

    public Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class Stack {
    Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if(top==null) {
            top = newNode;
            return;
        }
        newNode.link = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int data = top.info;
        top = top.link;
        return data;
    }

    public int peep() {
        if (top == null) {
            System.out.println("Stack Underflow");
        }
        return top.info;
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.info);
            temp = temp.link;
        }
    }
}

public class Lab60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        Stack stack = new Stack();
        
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
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.peep();
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