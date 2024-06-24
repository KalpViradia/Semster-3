import java.util.*;

public class Lab23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++){
            System.out.println("Enter the elements of the sorted array: ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number to be inserted: ");
        int number = sc.nextInt();
        int i;
        for(i=n-1;(i>=0 && arr[i]>number);i--){
            arr[i+1] = arr[i];
        }
        arr[i+1] = number;
        System.out.println("Array after insertion:");
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}