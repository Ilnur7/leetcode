package dynamic;

public class FibonacciNumber509 {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n-2);
    }

    public int fib1(int n) {
        if (n <= 1) return n;
        int n0 = 0;
        int n1 = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            res = n0 + n1;
            n0 = n1;
            n1 = res;
        }
        return res;
    }
}
