import java.util.*;
public class Lab16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i=0;
        for(i=0;i<n;i++){
            System.out.println("Enter an array value for "+i);
            arr[i]=sc.nextInt();
        }
        for(int a:arr){
            System.out.println(a);
        }
        int min=0;
        int max=0;
        for(i=0;i<n;i++){
            if(arr[min]>=arr[i]){
                min=i;
            }
            if(arr[max]<=arr[i]){
                max=i;
            }
        }
        System.out.println("Min Number index is "+min);
        System.out.println("Max Number index is "+max);
        sc.close();
    }
}