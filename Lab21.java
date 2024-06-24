import java.util.*;
public class Lab21 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of array :-");
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n+1];
        int i=0;
        for(i=0;i<n;i++){
            System.out.println("Enter a element for array index "+i+" :-");
            a[i]=sc.nextInt();
        }
        int index=sc.nextInt();
        for(i=0;i<n+1;i++){
            if(i<index){
                b[i]=a[i];
            }
            else if(i==index){
                b[i]=sc.nextInt();
            }
            else{
                b[i]=a[i+1];
            }
        }
        for(i=0;i<n+1;i++){
            System.out.println(b[i]);
        }
        sc.close();
    }
}