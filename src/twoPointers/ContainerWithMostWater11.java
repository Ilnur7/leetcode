package twoPointers;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(ints);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int min = Math.min(height[left], height[right]);
            int currentArea = min * (right - left);
            maxArea = Math.max(currentArea, maxArea);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
