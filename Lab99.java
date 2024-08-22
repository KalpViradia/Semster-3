import java.util.Scanner;

public class Lab99 {
    
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap=n/2; gap>0; gap/=2) {
            for (int i=gap; i<n; i++) {
                int temp = arr[i];
                int j;
                for (j=i; j>=gap && arr[j-gap]>temp; j-=gap) {
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
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

        shellSort(arr);

        System.out.println("Array elements after sorting: ");
        for (int i = 0;i < n;i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}