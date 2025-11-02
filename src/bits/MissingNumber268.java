package bits;

import static java.lang.Long.toBinaryString;

public class MissingNumber268 {

    public static void main(String[] args) {
        int i = missingNumber1(new int[]{0, 1, 2, 4, 5, 6});
        System.out.println("res: "+i);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int realSum = 0;

        for (int i = 0; i < n; i++) {
            realSum += nums[i];
        }
        return expectedSum - realSum;
    }

    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for (int i = 0; i < n; i++) {
            System.out.print(toBinaryString(i) + " : " + toBinaryString(nums[i]));
            //если i и nums[i] не равны то разность надо уничтожить потом когда найдется пара, так как массив не отсортиван
            xor = xor ^ i ^ nums[i]; //нужно пройти все пары, потому что иногда «свой индекс» элемент встретит не в той же итерации, а позже.
            System.out.println("     " + xor + " : " + Integer.toBinaryString(xor));
        }
        return xor ^ n; //После выхода из цикла мы ещё делаем xor ^ n, чтобы добавить недостающее число n (ведь в массиве индексы только до n-1

    }
}
