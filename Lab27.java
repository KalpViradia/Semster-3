import java.util.*;

public class Lab27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String toggledString = toggleCase(input);
        System.out.println("String after toggling case: " + toggledString);
        scanner.close();
    }
    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (char ch : str.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}