package character.string;

import java.util.Scanner;

/**
 * ClassName: ReplaceNum
 * Package: character.string
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-04-25 17:52
 * @Version 1.0
 */
public class ReplaceNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        ReplaceNum str = new ReplaceNum();
        String outputStr = str.replaceNum(inputStr);
        System.out.println(outputStr);
        scanner.close();
    }

    public String replaceNum(String inputStr) {
        int count = 0;
        int oldLength = inputStr.length();
        for (int i = 0; i < inputStr.length(); i++) {
            if(Character.isDigit(inputStr.charAt(i))) {
                count++;
            }
        }
        int newLength = oldLength + 5*count;
        char[] newStr = new char[newLength];
        System.arraycopy(inputStr.toCharArray(), 0, newStr, 0, oldLength);
        for (int i = newLength - 1, j = oldLength - 1; i > j; i--, j--) {
            if(!Character.isDigit(newStr[j])){
                newStr[i] = newStr[j];
            } else {
                newStr[i] = 'r';
                newStr[i - 1] = 'e';
                newStr[i - 2] = 'b';
                newStr[i - 3] = 'm';
                newStr[i - 4] = 'u';
                newStr[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(newStr);
    }
}
