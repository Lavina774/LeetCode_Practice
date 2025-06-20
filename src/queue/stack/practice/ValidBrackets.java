package queue.stack.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: ValidBrackets
 * Package: queue.stack.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-05-30 19:46
 * @Version 1.0
 */
public class ValidBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bracketS;
        String regex = "^[(){}\\[\\]]*$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            System.out.println("Please enter a String only include brackets: ");
            bracketS = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(bracketS);
            if(matcher.matches()) {
                break;
            } else {
                System.out.println("Invalid input, please enter your string again: ");
            }
        }

        Boolean result = isValid(bracketS);
        System.out.println("The input is valid: " + result);
    }
    
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
