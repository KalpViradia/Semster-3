import java.util.*;

public class Lab25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int newSize = removeDuplicates(arr,n);
        System.out.println("Array after removing duplicates:");
        for(int i=0;i<newSize;i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
    public static int removeDuplicates(int[] arr, int n) {
        if(n==0 || n==1){
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for(int i=0;i<n-1;i++){
            if(arr[i]!=arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        for(int i=0;i<j;i++){
            arr[i] = temp[i];
        }
        return j;
    }
}