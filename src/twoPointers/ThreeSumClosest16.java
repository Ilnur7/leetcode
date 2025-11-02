package twoPointers;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = first + nums[left] + nums[right];
                int curDiff = Math.abs(sum - target);
                if (curDiff < diff) {
                    diff = curDiff;
                    res = sum;
                }

                if (sum > target) {
                    right--;
                } else if (sum < target){
                    left++;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }
}
