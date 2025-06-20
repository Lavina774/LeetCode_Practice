package hash.table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TwoSum
 * Package: hash.table
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 02:12
 * @Version 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int balance = target - nums[i];  // 记录当前的目标值的余数
            if(indexMap.containsKey(balance)){  // 查找当前的map中是否有满足要求的值
                return new int []{i, indexMap.get(balance)}; //  如果有，返回目标值
            } else{
                indexMap.put(nums[i], i); //  如果没有，把访问过的元素和下标加入map中
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        int m=0,n=0,k,board=0;
        int[] res=new int[2];
        int[] tmp1=new int[nums.length];
        //备份原本下标的nums数组
        System.arraycopy(nums,0,tmp1,0,nums.length);
        //将nums排序
        Arrays.sort(nums);
        //双指针
        for(int i=0,j=nums.length-1;i<j;){
            if(nums[i]+nums[j]<target)
                i++;
            else if(nums[i]+nums[j]>target)
                j--;
            else if(nums[i]+nums[j]==target){
                m=i;
                n=j;
                break;
            }
        }
        //找到nums[m]在tmp1数组中的下标
        for(k=0;k<nums.length;k++){
            if(tmp1[k]==nums[m]){
                res[0]=k;
                break;
            }
        }
        //找到nums[n]在tmp1数组中的下标
        for(int i=0;i<nums.length;i++){
            if(tmp1[i]==nums[n]&&i!=k)
                res[1]=i;
        }
        return res;
    }
}
