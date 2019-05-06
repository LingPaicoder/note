package com.lpcoder.test.fibonacci;

import java.util.HashMap;

/**
 * @author liurenpeng
 * @date Created in 19-5-6
 */
public class Fibonacci {

    // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233 ...

    // 1.递归 2.递归+HashMap缓存 3.递归+数组缓存 4.数组缓存+顺序递推 5.顺序递推

    // 参考资料1：https://blog.csdn.net/acecandy/article/details/83864763#5_104
    // 参考资料2：https://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&mid=2651961606&idx=1&sn=0ad1a2eec0c2a0187034c258ef63fab2&chksm=bd2d0cda8a5a85cc1cee07fca7d877a79d7146aac5021c55340a8b6ae595942319d496d51806&mpshare=1&scene=1&srcid=05066pvvGUnJPMPgn4GEg6PF&pass_ticket=vEcSQRCnDnxQnn8RZnIVLso%2Fj9ZT3AoAg2i5Fiu5H9NXhOSCh5FRJC3yVgsPS94r#rd

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(f4(5000));
        long end = System.currentTimeMillis();
        System.out.println("used:" + (end - start));
    }

    /**
     * 顺序递推
     */
    private static long f5(int n) {
        checkN(n);
        long rst = 0;
        long first = 1L;
        long second = 1L;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                rst = 1L;
            } else {
                rst = first + second;
                first = rst;
                second = first;
            }
        }
        return rst;
    }

    /**
     * 数组缓存+顺序递推
     */
    private static long f4(int n) {
        checkN(n);
        for (int i = 1; i <= n; i++) {
            long rst;
            if (i == 1 || i == 2) {
                rst = 1L;
            } else {
                rst = f4Arr[i - 1] + f4Arr[i - 2];
            }
            f4Arr[i] = rst;
        }
        return f4Arr[n];
    }

    private static final long[] f4Arr = new long[10000];

    /**
     * 递归+数组缓存
     */
    private static long f3(int n) {
        checkN(n);
        if (n == 1 || n == 2) {
            return 1;
        }
        if (f3Arr[n] > 0) {
            return f3Arr[n];
        }
        f3Arr[n] = f3(n - 1) + f3(n - 2);
        return f3Arr[n];
    }

    private static final long[] f3Arr = new long[10000];

    /**
     * 递归+HashMap缓存
     */
    private static long f2(int n) {
        checkN(n);
        if (n == 1 || n == 2) {
            return 1;
        }
        if (!f2Map.containsKey(n)) {
            f2Map.put(n, f2(n - 1) + f2(n - 2));
        }
        return f2Map.get(n);
    }

    private static final HashMap<Integer, Long> f2Map = new HashMap<>();

    /**
     * 递归
     */
    private static long f1(int n) {
        checkN(n);
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    private static void checkN(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("arg err: n <= 0");
        }
    }

}
