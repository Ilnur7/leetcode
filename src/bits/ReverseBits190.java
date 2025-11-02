package bits;

public class ReverseBits190 {
    public static void main(String[] args) {
        reverseBits(13);
    }

    public static int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        int res = 0;

        for (int i = 0; i < 32; i++) {

            int lastBit = n & 1;
            System.out.println(Integer.toBinaryString(lastBit));

            res = res << 1;
            System.out.println(Integer.toBinaryString(res));

            res = res | lastBit;
            System.out.println(Integer.toBinaryString(res));

            n = n >> 1;
            System.out.println(Integer.toBinaryString(n));
            System.out.println("----------------");
        }
        return res;
    }
}
