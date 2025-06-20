package back.tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Combine
 * Package: back.tracking
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 03:00
 * @Version 1.0
 */
public class Combine {
    List<List<Integer>> result= new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>(); // 用来存放符合条件结果
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    public void backtracking(int n,int k,int startIndex){ //startIndex来记录下一层递归，搜索的起始位置
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex;i<=n;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
}
