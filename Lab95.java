import java.util.Scanner;
import java.util.Arrays;

public class Lab95 {

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void countingSort(int[] arr,int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count,0);
        for (int i=0; i<n; i++) {
            int index = (arr[i]/exp)%10;
            count[index]++;
        }
        for (int i=1; i<10; i++) {
            count[i] += count[i-1];
        }
        for (int i=n-1; i>=0; i--) {
            int index = (arr[i]/exp)%10;
            output[count[index]-1] = arr[i];
            count[index]--;
        }
        System.arraycopy(output,0,arr,0,n);
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp=1; max/exp>0; exp=10) {
            countingSort(arr,exp);
        }
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

        radixSort(arr);

        System.out.println("Array elements after sorting: ");
        for (int i = 0;i < n;i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
