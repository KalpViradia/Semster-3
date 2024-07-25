import java.util.Scanner;

class QueueMethod {
    int front, rear = -1;
    int n;
    int[] arr;

    public QueueMethod(int n) {
        this.n =n;
        arr = new int[n];
    }

    public void Enqueue(int x) {
        if(rear > arr.length-1) {
            System.out.println("Queue Overflow");
            return;
        }
        front = 0;
        rear++;
        arr[rear] = x;
        if(front == -1) {
            System.out.println("Queue Underflow");
            return;
        }
    }

    public void Dequeue() {
        if(rear == -1) {
            System.out.println("Queue Underflow");
            return;
        }
        arr[front] = -1;
        front++;
    }

    public void display() {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class Lab50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of queue: ");
        int n = sc.nextInt();
        QueueMethod queue = new QueueMethod(n);
        int choice, x;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    x = sc.nextInt();
                    queue.Enqueue(x);
                    break;
                case 2:
                    System.out.println("Dequeue done");
                    queue.Dequeue();
                    break;
                case 3:
                    System.out.print("Queue is: ");
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}