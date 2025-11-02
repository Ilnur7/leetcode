package twoPointers;

public class SquaresSortedArray977 {
    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-4,-1,0,3,10});
        System.out.println(ints);
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int[] res = new int[nums.length];
        int count = res.length -1;
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            if (nums[left] > nums[right]) {
                res[count] = nums[left];
                left++;
                count--;
            } else{
                res[count] = nums[right];
                right--;
                count--;
            }
        }
        return res;
    }
}
