package arrays;

public class PlusOne66 {
    public static void main(String[] args) {

    }

    public static    int[] plusOne(int[] digits) {
        int num = 0;
        int multiply = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
