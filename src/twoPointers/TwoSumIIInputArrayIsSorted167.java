package twoPointers;

public class TwoSumIIInputArrayIsSorted167 {

    public static void main(String[] args) {
        //int[] ints = twoSum1(new int[]{2, 3, 4}, 6);
        int[] ints = twoSum1(new int[]{2, 7, 11,15}, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[] {left+1, right+1};
            }
            if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length -1;
            int findNumber = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == findNumber) {
                    return new int[] {i, mid};
                }
                if (numbers[mid] > findNumber) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return null;
    }
}
