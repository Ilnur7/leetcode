package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[] {i, map.get(tmp)};
            }
            map.put(nums[i], i);
        }
        return null;

/*        if (nums == null || nums.length == 0) return null;
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] {left, right};
            }
            if (count % 2 == 0) {
                right--;
            } else {
                left++;
            }
            count++;
        }
        return null;*/
    }
}
