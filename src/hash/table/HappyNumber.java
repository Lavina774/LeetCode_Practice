package hash.table;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: HappyNumber
 * Package: hash.table
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 02:10
 * @Version 1.0
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
