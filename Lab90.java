import java.util.Scanner;

public class Lab90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++) {
            System.out.println("Enter value for element in index "+i+": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to find: ");
        int x = sc.nextInt();
        int count = 0;
        for(int i = 0;i < n;i++) {
            if(arr[i] == x) {
                count = i;
                break;
            }
        }
        if(count != 0) {
            System.out.println("Element found at index "+count);
        }
        else{
            System.out.println("Element not found");
        }
        sc.close();
    }
}