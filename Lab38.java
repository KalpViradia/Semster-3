import java.util.*;

class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push value.");
        } else {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " into the stack.");
        }
    }

    public int pop(int i) {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop value.");
            return -1;
        } else {
            int poppedValue = stackArray[top- i + 1];
            System.out.println("Popped " + poppedValue + " from the stack.");
            return poppedValue;
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }

    public void peep() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element is: " + stackArray[top]);
        }
    }

    public void change(int position, int newValue) {
        if (position <= 0 || position > top + 1) {
            System.out.println("Invalid position.");
        } else {
            stackArray[position - 1] = newValue;
            System.out.println("Changed element at position " + position + " to " + newValue);
        }
    }
}    

public class Lab38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. DISPLAY");
            System.out.println("4. PEEP");
            System.out.println("5. CHANGE");
            System.out.println("6. EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    System.out.print("Enter postion of the element to be poped: ");
                    int i = sc.nextInt();
                    stack.pop(i);
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.peep();
                    break;
                case 5:
                    System.out.print("Enter position to change: ");
                    int position = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = sc.nextInt();
                    stack.change(position, newValue);
                    break;
                case 6:
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