import java.util.*;

public class Lab15 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int i=0;
        double avg=0;
        for(i=1;i<=n;i++){
            avg=avg+i;
        }
        avg=avg/n;
        System.out.println("Average is "+avg);
        sc.close();
    }
}