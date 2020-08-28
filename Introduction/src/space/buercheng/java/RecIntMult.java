package space.buercheng.java;

/**
 * 递归计算长整数乘法：
 * 输入：两个长度为n的整数x，y
 * 输出：x×y的乘积
 * n是2的幂:2,4,8,16...
 **/
public class RecIntMult {
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
        long x = 12345678, y = 56789012;
        long result = recMult(x, y);
        System.out.println(result);
    }

    public static long recMult(long x, long y) {
        //x，y位数相同
        int n = countDigits(x);
        if (n == 1)
            return x * y;
        int m = (int) Math.pow(10, n / 2);
        long a = x / m;
        long b = x % m;
        long c = y / m;
        long d = y % m;
        long pac = recMult(a, c);
        long pad = recMult(a, d);
        long pbc = recMult(b, c);
        long pbd = recMult(b, d);
        long result = pac * (long) Math.pow(10, n) +
                (pad + pbc) * (long) Math.pow(10, n / 2) +
                pbd;
        return result;
    }
}
