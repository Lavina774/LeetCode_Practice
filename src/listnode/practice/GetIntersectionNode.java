

/**
 * ClassName: GetIntersectionNode
 * Package: listnode.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-04-22 18:03
 * @Version 1.0
 */
package listnode.practice;

import java.util.*;

import static listnode.practice.ListOperation.createList;

public class GetIntersectionNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 获取两个链表的输入
        int[] listA = getList(scanner);
        ListNode headA = createList(listA);

        int[] listB = getList(scanner);
        ListNode headB = createList(listB);

        // 👇 自动制造交点（可选）
        System.out.print("是否制造交点？输入 yes 或 no: ");
        String choice = scanner.nextLine().trim();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("请输入 A 链表中交点的索引位置（从 0 开始）: ");
            int index = Integer.parseInt(scanner.nextLine());
            connectAtIntersection(headA, headB, index);
        }

        // 查找交点
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        if (intersectionNode != null) {
            System.out.println("交点值为: " + intersectionNode.val);
        } else {
            System.out.println("Not intersect");
        }

        scanner.close();
    }

    // 输入一行整数转为数组
    public static int[] getList(Scanner scanner) {
        while (scanner.hasNextLine()) {
            try {
                String data = scanner.nextLine().trim();
                if (data.isEmpty()) break;

                String[] parts = data.split("\\s+");
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i]);
                }
                return arr;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }
        return new int[0];
    }


    // 查找交点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (lenB > lenA) {
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        int gap = lenA - lenB;
        while (gap > 0) {
            curA = curA.next;
            gap--;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }

    // 自动制造交点：让 headB 的尾部连到 headA 的某个节点
    public static void connectAtIntersection(ListNode headA, ListNode headB, int indexA) {
        if (headA == null || headB == null) return;

        // 找 A 链表第 indexA 个节点
        ListNode intersection = headA;
        for (int i = 0; i < indexA && intersection != null; i++) {
            intersection = intersection.next;
        }

        if (intersection == null) {
            System.out.println("索引超出范围，无法制造交点。");
            return;
        }

        // 找到 B 链表最后一个节点
        ListNode tailB = headB;
        while (tailB.next != null) {
            tailB = tailB.next;
        }

        // 连接
        tailB.next = intersection;
        System.out.println("已成功制造交点在值为: " + intersection.val);
    }

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] hash = new int[26];
        if (words.length == 0) return result;
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] otherHash = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                otherHash[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], otherHash[k]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if(hash[i] != 0) {
                for (int j = 0; j < hash[i]; j++) {
                    result.add(String.valueOf((char)(i + 'a')));
                }
            }
        }
        return result;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }
        for (int j : nums2) {
            if(set.contains(j)){
                resultSet.add(j);
            }
        }
        int[] result = new int[resultSet.size()];
        int j = 0;
        for(int i : resultSet){
            result[j++] = i;
        }
        return result;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n!= 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n==1;
    }

    public int getNextNumber(int n) {
        int res = 0;
        while(n > 0) {
            int digit = n % 10;
            res += digit*digit;
            n = n / 10;
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            for (int k : nums2) {
                int keyNum = j + k;
                if (map.containsKey(keyNum)) {
                    map.put(keyNum, map.get(keyNum) + 1);
                } else {
                    map.put(keyNum, 1);
                }
            }
        }
        int count = 0;
        for (int j : nums3) {
            for (int k : nums4) {
                int temp = j + k;
                if (map.containsKey(-temp)) {
                    count += map.get(-temp);
                }
            }
        }
        return count;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            characterMap.put(magazine.charAt(i), characterMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            characterMap.put(c, characterMap.getOrDefault(c, 0) - 1);
            if (characterMap.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] character = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            character[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            character[ransomNote.charAt(i) - 'a']--;
        }
        for(int value : character) {
            if(value < 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return results;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > target && nums[i] >=0 ) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) break;
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        int leftVal = nums[left];
                        int rightVal = nums[right];     // Important！ Caution！
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == leftVal) left++;
                        while (left < right && nums[right] == rightVal) right--;
                    }
                }
            }
        }
        return result;
    }
}
