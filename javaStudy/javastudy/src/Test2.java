public class Test2 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 5, 8, 4, 6, 7, 9, 11};
        findKthLargest(nums, 4);

        for (int num : nums) {
            System.out.println(num);
        }

    }


    public static int findKthLargest(int[] nums, int k) {

        int length = nums.length;
        return nums[length - k];


    }


}
