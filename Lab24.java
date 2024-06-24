import java.util.*;

public class Lab24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the sorted array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number to be deleted: ");
        int number = sc.nextInt();
        int index = -1;
        for(int i=0;i<n;i++){
            if(arr[i] == number){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Number not found in the array.");
        }else{
            for(int i=index;i<n-1;i++){
                arr[i] = arr[i+1];
            }
            n--;
            System.out.println("Array after deletion:");
            for(int i=0;i<n;i++) {
                System.out.print(arr[i] + " ");
            }
        }
        sc.close();
    }
}