import java.util.Scanner;

public class Lab91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter a Sorted array: ");
        for(int i = 0;i < n;i++) {
            System.out.println("Enter value for element in index "+i+": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to find: ");
        int x = sc.nextInt();
        int left = 0;
        int right = n-1;
        int middle;
        while(left <= right) {
            middle = (left+right)/2;
            if(arr[middle] == x) {
                System.out.println("Element found at index "+middle);
                return;
            }
            else if(x < arr[middle]) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        System.out.println("Element not found");
        sc.close();
    }
}

//Recursive Method :-

// public class Lab91 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the length of the array: ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         System.out.println("Enter a Sorted array: ");
//         for(int i = 0; i < n; i++) {
//             System.out.println("Enter value for element in index " + i + ": ");
//             arr[i] = sc.nextInt();
//         }
//         System.out.println("Enter element to find: ");
//         int x = sc.nextInt();
        
//         int result = binarySearch(arr, 0, n - 1, x);
//         if (result == -1) {
//             System.out.println("Element not found");
//         } else {
//             System.out.println("Element found at index " + result);
//         }
//     }

//     public static int binarySearch(int[] arr, int left, int right, int x) {
//         if (left <= right) {
//             int middle = (left + right) / 2;

//             if (arr[middle] == x) {
//                 return middle;
//             } else if (x < arr[middle]) {
//                 return binarySearch(arr, left, middle - 1, x);
//             } else {
//                 return binarySearch(arr, middle + 1, right, x);
//             }
//         }
//         return -1;
//     }
// }