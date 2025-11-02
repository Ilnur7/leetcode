package bits;

public class SumTwoIntegers371 {

    public int getSum(int a, int b) {

        while (b != 0) { //Условие while (b != 0) гарантирует, что мы учтём все переносы, пока сумма не станет окончательной.
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry; //если carry вначале его надо учитывать далее
        }
        return a;
    }
}
