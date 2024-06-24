import java.util.*;
public class Lab17 {
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
        int j=0;
        int c=0;
        for(j=0;j<n;j++){
            for(i=j+1;i<n;i++){
                if(arr[i]==arr[j]){
                    c++;
                }
            }        
        }
        if(c==0){
            System.out.println("No Duplicate Value added");
        }
        else{
            System.out.println("Duplicate Value added");
        }
        sc.close();
    }
}