package com.lpcoder.test.pacer_health;


/**
 * @author liurenpeng
 * @date Created in 18-12-28
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //System.out.println(Integer.toBinaryString(4));
        //System.out.println(Integer.MAX_VALUE);

        System.out.println(solution(955));
        //System.out.println(solution(4));
    }

    static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }

        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = !(l == p || l == 1 || (l == 2 && d[0] == 0));
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }
}
