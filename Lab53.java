import java.util.Arrays;

public class PriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int index) {
        int parentIndex = parent(index);
        if (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Priority queue is full.");
            return;
        }
        heap[size] = element;
        size++;
        heapifyUp(size - 1);
    }

    public int delete() {
        if (size == 0) {
            System.out.println("Priority queue is empty.");
            return Integer.MIN_VALUE;
        }
        int removedElement = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return removedElement;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Priority queue is empty.");
        } else {
            System.out.println("Priority queue elements:");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    }
}

public class Lab53 {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(10);
        pq.insert(20);
        pq.insert(15);
        pq.insert(30);
        pq.insert(40);

        pq.display();

        System.out.println("Deleted element: " + pq.delete());
        pq.display();
    }
}