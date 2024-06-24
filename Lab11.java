import java.util.*;

public class Lab11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int totalSum = 0;
        int partialSum = 0;

        for (int i = 1; i <= n; i++) {
            partialSum += i;
            totalSum += partialSum;
        }

        System.out.println("The sum of the series is: " + totalSum);

        sc.close();
    }
}
