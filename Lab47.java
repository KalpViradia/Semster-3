import java.util.Scanner;
import java.util.Stack;

public class Lab47 {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a postfix expression: ");
        String postfix = sc.nextLine();
        
        try {
            int result = evaluatePostfix(postfix);
            System.out.println("Evaluated Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid postfix expression");
        }
        sc.close();
    }
}