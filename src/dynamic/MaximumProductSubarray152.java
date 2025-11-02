package dynamic;

public class MaximumProductSubarray152 {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1, suffix = 1;
        int result = nums[0];

        for (int i = 0; i < n; i++) {
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            suffix = (suffix == 0 ? 1 : suffix) * nums[n - 1 - i];
            result = Math.max(result, Math.max(prefix, suffix));
        }

        return result;
    }

    public int maxProduct1(int[] nums) {
        int res = nums[0];
        int maxCur = nums[0];
        int minCur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            if (cur < 0) {
                int tmp = maxCur;
                maxCur = minCur;
                minCur = tmp;
            }

            maxCur = Math.max(cur, maxCur * cur);
            minCur = Math.min(cur, minCur * cur);

            res = Math.max(res, maxCur);
        }

        return res;
    }
}
