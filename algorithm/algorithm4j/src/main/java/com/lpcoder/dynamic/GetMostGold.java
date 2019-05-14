package com.lpcoder.dynamic;

/**
 * http://www.sohu.com/a/153858619_466939
 *
 * @author liurenpeng
 * @date Created in 19-5-14
 */
public class GetMostGold {

    public static void main(String[] args) {
        int[] g = new int[]{400, 500, 200, 300, 350};
        int[] p = new int[]{5, 5, 3, 4, 3};
        System.out.println(getMostGold(5, 10, g, p));
    }

    /**
     * 解决方案
     *
     * @param n 金矿数量
     * @param w 工人数
     * @param g 金矿的黄金量
     * @param p 金矿的用工量
     * @return 最大金矿数
     */
    private static int getMostGold(int n, int w, int[] g, int[] p) {
        int[] preResults = new int[w];
        int[] results = new int[w];
        int[] sums = getSums(p);

        // 填充边界格子的值
        for (int i = 0; i < w; i++) {
            if (i < p[0]) {
                preResults[i] = 0;
            } else {
                preResults[i] = g[0];
            }
        }

        // 填充其余格子的值，外层循环是金矿数量，内层循环是工人数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < p[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
                }
            }
            preResults = results;
        }
        return results[n];
    }

    private static int[] getSums(int[] p) {
        int[] sums = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            if (i == 0) {
                sums[i] = p[i];
            } else {
                sums[i] = sums[i - 1] + p[i];
            }
        }
        return sums;
    }

}
