import java.util.*;

public class Lab22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the elements of the array: ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the location from which to delete the element: ");
        int m = sc.nextInt();
        if(m<0 || m>=n){
            System.out.println("Invalid location");
        } else {
            for(int i=m;i<n-1;i++){
                arr[i] = arr[i+1];
            }
            System.out.println("Array after deletion:");
            for (int i=0;i<n-1;i++) {
                System.out.print(arr[i] + " ");
            }
        }
        sc.close();
    }
}