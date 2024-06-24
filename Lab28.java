import java.util.Scanner;

public class Lab28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int sum = sum(array);
        int min = min(array);
        int max = max(array);
        double avg = avg(array);
        System.out.println("Sum: " + sum);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Average: " + avg);
        scanner.close();
    }
    public static int sum(int[] array) {
        int total = 0;
        for (int num : array) {
            total += num;
        }
        return total;
    }
    public static int min(int[] array) {
        int minimum = array[0];
        for (int num : array) {
            if (num < minimum) {
                minimum = num;
            }
        }
        return minimum;
    }
    public static int max(int[] array) {
        int maximum = array[0];
        for (int num : array) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }
    public static double avg(int[] array) {
        int total = sum(array);
        return (double) total / array.length;
    }
}