package queue.stack.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: RemoveDuplicates
 * Package: queue.stack.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-04 19:42
 * @Version 1.0
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        String regex = "^[a-z]*$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            System.out.println("Please enter a string consisting of lowercase English letters: ");
            s = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(s);
            if(matcher.matches()) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        scanner.close();
        String result = removeDuplicates(s);
        System.out.println("Result after removing duplicates: " + result);
    }
    public static String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
