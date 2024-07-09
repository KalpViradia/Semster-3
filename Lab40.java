import java.util.*;

public class Lab40 {

    public static boolean isValidForm(String input) {
        int length = input.length();
        if (length % 2 != 0) {
            return false;
        }

        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            if (input.charAt(i) != 'a') {
                return false;
            }
        }

        for (int i = mid; i < length; i++) {
            if (input.charAt(i) != 'b') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to check if it is of the form a^i b^i: ");
        String input = sc.nextLine();

        if (isValidForm(input)) {
            System.out.println("The string \"" + input + "\" is of the form a^i b^i.");
        } else {
            System.out.println("The string \"" + input + "\" is not of the form a^i b^i.");
        }

        sc.close();
    }
}