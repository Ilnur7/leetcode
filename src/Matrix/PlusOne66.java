package Matrix;

public class PlusOne66 {
    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public int[] plusOne1(int[] digits) {
        // Iterate over the digits from right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            // Add 1 to the current digit
            digits[i]++;
            // If the digit is less than 10, no need to carry over
            if (digits[i] < 10) {
                return digits;
            }
            // If the digit becomes 10, set it to 0 and continue with the next digit
            digits[i] = 0;
        }
        // If we reach here, it means all digits became 10, so we need to create a new array with one extra digit
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Set the leftmost digit to 1
        return result;
    }
}
