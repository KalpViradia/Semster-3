import java.util.*;
public class Lab14 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Starting Number");
        int m=sc.nextInt();
        System.out.println("Enter Ending Number");
        int n=sc.nextInt();
        int i=0;
        int sum=0;
        for(i=m;i<=n;i++){
            sum=sum+i;
        }
        System.out.println("Sum of the number is "+sum);
        sc.close();
    }
}