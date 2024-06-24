import java.util.*;

public class Lab26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the first array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the elements of the second array: ");
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        int[] mergedArray = mergeArrays(arr, arr1);
        System.out.println("Merged array:");
        System.out.println(Arrays.toString(mergedArray));
        sc.close();
    }

    public static int[] mergeArrays(int[] arr, int[] arr1) {
        int n = arr.length;
        int n1 = arr1.length;
        int[] mergedArray = new int[n+n1];
        for(int i=0;i<n;i++){
            mergedArray[i] = arr[i];
        }
        for(int i=0;i<n1;i++){
            mergedArray[n+i] = arr1[i];
        }
        return mergedArray;
    }
}