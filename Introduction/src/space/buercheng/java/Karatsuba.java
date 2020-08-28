package space.buercheng.java;

import java.util.Scanner;

public class Karatsuba {
    /**
     * 唐津算法，改进的递归算法
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
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数:");
        long x = sc.nextLong();
        long y = sc.nextLong();
        long result = karatsuba(x, y);
        System.out.printf("%d × %d = %d", x, y, result);
    }

    //x，y位数不同
    public static long karatsuba(long x, long y) {
        //计算x，y的长度，找出两者中较大的位数，如果最大位数小于10位则直接计算结果
        int nx = countDigits(x);
        int ny = countDigits(y);
        int n = Math.max(nx, ny);
        if (n == 1)
            return x * y;
        int N = (n / 2) + n % 2;
        long m = (long) Math.pow(10, N);
        long a = x / m;
        long b = x % m;
        long c = y / m;
        long d = y % m;
        long z0 = a * c;
        long z1 = b * d;
        long z2 = (a + b) * (c + d);
        long z3 = z2 - z1 - z0;
        long result = z0 * (long)Math.pow(10,2*N) + z1 + z3 * (long)Math.pow(10,N);
        return result;
    }
   /* //x，y位数相同
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
    }*/
}
