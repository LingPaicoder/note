package com.lpcoder.test.fibonacci;

/**
 * 注意Java并不支持尾递归优化，这里只是表达尾递归的思路
 *
 * @author liurenpeng
 * @date Created in 19-5-6
 */
public class FibonacciTailRecursion {

    public static void main(String[] args) {
        System.out.println(solution(10, 0, 1));
    }

    private static long solution(int n, long second, long first) {
        if (0 == n) {
            return second;
        }
        return solution(n - 1, first, second + first);
    }

}
