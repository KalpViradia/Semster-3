import java.util.*;

public class Lab19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's triangle: ");
        int numRows = sc.nextInt();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows - i - 1; j++) {
                System.out.print(" ");
            }

            int value = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(value + " ");
                value = value * (i - j) / (j + 1);
            }

            System.out.println();
        }
        sc.close();
    }
}
