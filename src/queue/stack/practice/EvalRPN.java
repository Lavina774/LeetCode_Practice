package queue.stack.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * ClassName: EvalRPN
 * Package: queue.stack.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-04 20:41
 * @Version 1.0
 */
public class EvalRPN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] tokens;

        System.out.println("Enter a valid RPN expression (e.g. '3 4 +'): ");
        input = scanner.nextLine().trim();
        tokens = input.split("\\s+");

        scanner.close();
        int result = evalRPN(tokens);
        System.out.println("The result is: " + result);
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                if (deque.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: not enough operands.");
                }
                int i1 = deque.pop();
                int i2 = deque.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = i2 + i1;
                        break;
                    case "-":
                        res = i2 - i1;
                        break;
                    case "*":
                        res = i2 * i1;
                        break;
                    case "/":
                        if (i1 == 0) {
                            throw new ArithmeticException("Division by zero.");
                        }
                        res = i2 / i1;
                        break;
                }
                deque.push(res);
            } else {
                try {
                    deque.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }
        }

        if (deque.size() != 1) {
            throw new IllegalStateException("Invalid RPN expression.");
        }

        return deque.pop();
    }

}
