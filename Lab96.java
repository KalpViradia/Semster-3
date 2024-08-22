import java.util.Scanner;

public class Lab96 {
    
    public static void merge(int[] arr,int left,int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr,left,L,0,n1);
        System.arraycopy(arr,mid+1,R,0,n2);
        int i = 0;
        int j = 0;
        int k = left;
        while (i<n1 && j<n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i<n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j<n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left<right) {
            int mid = left+(right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
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

        int left = 0;
        int right = n-1;

        mergeSort(arr, left, right);

        System.out.println("Array elements after sorting: ");
        for (int i = 0;i < n;i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}