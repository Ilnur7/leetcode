package slidingwindow;

public class MaximumAverageSubarray643 {
    public static void main(String[] args) {

    }

    public double findMaxAverage(int[] nums, int k) {
        int begin = 0;
        int windowSum = 0;
        int res = -Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];
            if (end - begin + 1 == k) {
                res = Math.max(res, windowSum);
                windowSum -= nums[begin];
                begin++;

            }
        }
        return (double)res / k;
    }

    public static double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return (double)maxSum / k;
    }
}
