import java.util.*;

class PalindromeChecker {
    private int maxSize;
    private int top;
    private char[] stackArray;

    public PalindromeChecker(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public boolean isPalindrome(String input) {
        int length = input.length();
        PalindromeChecker stack = new PalindromeChecker(length);

        for (int i = 0; i < length; i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < length; i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

public class Lab39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to check if it is a palindrome: ");
        String input = sc.nextLine();
        
        PalindromeChecker checker = new PalindromeChecker(input.length());
    
        if (checker.isPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }
    
        sc.close();
    }
}