import java.util.*;

public class Lab13{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i=0;
        for(i=0;i<n;i++){
            System.out.println("Enter an array value for "+i);
            arr[i]=sc.nextInt();
        }
        for(i=0;i<n;i++){
            System.out.println(arr[i]);
        }
        sc.close();
    }
}