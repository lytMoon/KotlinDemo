import java.util.*;

public class Solution {
    public boolean isValid(String s) {

        // 用hashMap来储存正常的对应格式
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');


        // 使用栈来追踪括号
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            //如果是左括号
            if (hashMap.containsKey(c)) {
                stack.push(c);
            } else {

                Character temp = stack.isEmpty() ? '*' : stack.pop();
                if (c == hashMap.get(temp)) {

                } else {
                    return false;
                }
            }


        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2,3,3,4,4,4, 4, 4, 5, 6};
        System.out.println(midSearch(nums,4));

        List<Integer> temp = new ArrayList<>();

        int b = 20;
        change(b);
        System.out.println(b);

    }

    static void change(int a){
        a= 10;

    }


    static int midSearch(int[] nums, int target) {
        int index=-1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }


}
