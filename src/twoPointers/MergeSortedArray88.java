package twoPointers;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = {0};
        merge1(nums1, 0, new int[] {1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int k = m + n - 1;
        int j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums2[j] < nums1[i]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n -1;
        int k = nums1.length -1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums2[i2] > nums1[i1]) {
                nums1[k] = nums2[i2];
                k--;
                i2--;
            } else {
                nums1[k] = nums1[i1];
                k--;
                i1--;
            }
        }

        while (i2 >= 0) {
            nums1[k] = nums2[i2];
            i2--;
            k--;
        }
    }
}
