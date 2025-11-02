package bits;

public class Number1Bits191 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) { // int = 32 бита
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1; // сдвигаем число вправо
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // убираем младший установленный бит
            count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }
}
