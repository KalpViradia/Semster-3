import java.util.Scanner;
import java.util.Stack;

public class Lab48 {
    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                switch (ch) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a prefix expression: ");
        String prefix = sc.nextLine();
        
        try {
            int result = evaluatePrefix(prefix);
            System.out.println("Evaluated Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid prefix expression");
        }
        sc.close();
    }
}