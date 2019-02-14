package com.lpcoder.stackAndQueue;

import java.util.Stack;

/**
 * @author liurenpeng
 * @date Created in 19-2-13
 */
public class HanoiTower {

    /**
     * 汉诺塔问题
     *
     * @param n           需要移动的盘子数
     * @param origin      出发栈
     * @param destination 目的栈
     * @param helper      辅助栈
     */
    public static void resolve(int n, Stack<Integer> origin,
                               Stack<Integer> destination, Stack<Integer> helper) {
        if (n == 0) {
            return;
        }
        // 把n-1个盘子，从出发栈移到辅助栈
        resolve(n - 1, origin, helper, destination);
        // 把第n个盘子(最底层的盘子)，从出发栈移到目的栈
        destination.push(origin.pop());
        // 把n-1个盘子，从辅助站移到目的栈
        resolve(n - 1, helper, destination, origin);
    }

    public static void main(String[] args) {
        int count = 16;
        Stack<Integer> origin = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        for (int i = count; i > 0; i--) {
            origin.push(i);
        }

        System.out.println(origin);
        resolve(count, origin, destination, helper);
        System.out.println(destination);
    }
}

// 输出
// [16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
// [16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
