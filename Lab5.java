import java.util.*;

public class Lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int n = sc.nextInt();
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
        sc.close();
    }
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}