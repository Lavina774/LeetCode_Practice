package array.practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: Dichotomy1
 * Package: array.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-03-31 15:06
 * @Version 1.0
 */
public class Dichotomy1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = inputLength(scanner);
        int target = inputTarget(scanner);
        ArrayList<Integer> list = getArray(length, scanner);
        int index = dichotomySolution(list, target);
        if (index == -1) {
            System.out.println("The array does not have the element:" + target);
        } else {
            System.out.println("The array has a number equals " + target + ", the index is: " + index);
        }
        scanner.close();
    }

    public static int dichotomySolution(ArrayList<Integer> list, int target) {
        if (list.isEmpty() || target < list.get(0) || target > list.get(list.size() - 1)) {
            return -1;
        }
        int left = 0; int right = list.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == list.get(mid)) {
                return mid;
            } else if (target < list.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int inputLength(Scanner scanner) {
        int length;
        while (true) {
            System.out.println("Please enter the length of the array:");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length > 0) {
                    break;
                } else {
                    System.out.println("The length must be greater than 0!");
                }
            } else {
                System.out.println("Please enter a valid integer!");
                scanner.next();
            }
        }
        return length;
    }

    public static int inputSingleElement(Scanner scanner, int index){
        int number;
        while (true) {
            System.out.println("Please enter number #" + index + ": ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Please enter a valid integer!");
                scanner.next();
            }
        }
        return number;
    }

    public static int inputTarget(Scanner scanner) {
        int number;
        while (true) {
            System.out.println("Please enter the target: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Please enter a valid integer!");
                scanner.next();
            }
        }
        return number;
    }

    public static ArrayList<Integer> getArray(int length, Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int current = inputSingleElement(scanner, i);
            if (current >= previous) {
                list.add(current);
                previous = current;
            } else {
                System.out.println("Please enter an integer greater than " + previous);
                i--;
            }
        }
        return list;
    }
}
