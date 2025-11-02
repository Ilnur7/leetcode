package twoPointers;

public class RemoveDuplicatesSortedArray26 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(l);
        int count = removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(count);
    }

    public static int removeDuplicates(int[] nums) {

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return ++slow;
    }
}
