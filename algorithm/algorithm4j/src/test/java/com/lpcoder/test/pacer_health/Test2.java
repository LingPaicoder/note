package com.lpcoder.test.pacer_health;

/**
 * @author liurenpeng
 * @date Created in 19-4-21
 */
public class Test2 {

    public static void main(String[] args) {
        //int[] A = {-8, 4, 0, 5, -3, 6};
        int[] A = {1, 3, -3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int[] startArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            startArr[i] = A[i] - i;
        }
        int[] endArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            endArr[i] = A[i] + i;
        }
        int rst = startArr[0] + endArr[0];
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                rst = Math.max(rst, startArr[i] + endArr[j]);
            }
        }
        return rst;
    }

}
