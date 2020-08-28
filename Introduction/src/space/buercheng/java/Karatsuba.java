package space.buercheng.java;

public class Karatsuba {
    /**
     * 唐津算法，改进的递归算法
     * 注意输入数的位数只能是2的幂次：2,4,8,16...2^n
     **/
//计算数字有多少位
    public static int countDigits(long num) {
        int n = 1;
        while (num / 10 > 0) {
            num /= 10;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        long x = 1234, y = 5678;
        long result = karatsuba(x, y);
        System.out.println(result);
    }

    public static long karatsuba(long x, long y) {
        //x，y位数相同
        int n = countDigits(x);
        if (n == 1)
            return x * y;
        int m = (int) Math.pow(10, n / 2);
        long a = x / m;
        long b = x % m;
        long c = y / m;
        long d = y % m;
        return (long) (Math.pow(10, n) * karatsuba(a, c) +
                Math.pow(10, n / 2) * ((a + b) * (c + d) - karatsuba(a, c) - karatsuba(b, d)) +
                karatsuba(b, d)
                );
    }
}
