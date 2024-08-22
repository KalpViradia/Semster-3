import java.util.Scanner;

public class Lab97 {
    
    public static void quickSort(int[] arr,int low,int high) {
        if (low < high) {
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0;i < n;i++) {
            System.out.println("Enter value for element in index "+i+": ");
            arr[i] = sc.nextInt();
        }

        int low = 0;
        int high = n-1;

        quickSort(arr, low, high);

        System.out.println("Array elements after sorting: ");
        for (int i = 0;i < n;i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}