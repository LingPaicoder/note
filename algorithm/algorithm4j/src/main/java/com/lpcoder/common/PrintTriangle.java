package com.lpcoder.common;

/**
 * @author liurenpeng
 * @date Created in 19-5-12
 */
public class PrintTriangle {

    public static void main(String[] args) {
        print(3);
    }

    public static void print(int n) {
        if (n < 1) {
            System.out.println("err arg");
            return;
        }
        for (int i = 1; i <= n; i++) {
            int bnum = n - i;
            int vnum = 2 * i - 1;
            for (int j = 1; j <= bnum; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= vnum; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= bnum; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
