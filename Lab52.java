import java.util.Scanner;

class DoubledQueue {
    int[] queue;
    int front;
    int rear;
    int size;

    public DoubledQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void insertFront(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }
        queue[front] = data;
    }

    public void insertRear(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (rear == -1) {
            rear = 0;
            front = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }
        queue[rear] = data;
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Deleted element from front: " + queue[front]);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Deleted element from rear: " + queue[rear]);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.print("Elements in the queue: ");
        if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println();
    }
}

public class Lab52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        DoubledQueue queue = new DoubledQueue(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front end");
            System.out.println("2. Insert at rear end");
            System.out.println("3. Delete from front end");
            System.out.println("4. Delete from rear end");
            System.out.println("5. Display all elements of the queue");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at front end: ");
                    int frontElement = scanner.nextInt();
                    queue.insertFront(frontElement);
                    break;
                case 2:
                    System.out.print("Enter element to insert at rear end: ");
                    int rearElement = scanner.nextInt();
                    queue.insertRear(rearElement);
                    break;
                case 3:
                    queue.deleteFront();
                    break;
                case 4:
                    queue.deleteRear();
                    break;
                case 5:
                    queue.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}