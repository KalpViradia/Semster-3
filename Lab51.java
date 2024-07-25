import java.util.Scanner;

class CircularQueue {
    int size, front, rear;
    int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        this.queue = new int[size];
    }

    public void insert(int element) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    public void delete() {
        if (front == -1) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Deleted " + queue[front]);
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue Underflow");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(queue[i] + " ");
                if (i == rear) {
                    break;
                }
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }
}

public class Lab51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the circular queue: ");
        int size = scanner.nextInt();
        CircularQueue queue = new CircularQueue(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    queue.insert(element);
                    break;
                case 2:
                    queue.delete();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}