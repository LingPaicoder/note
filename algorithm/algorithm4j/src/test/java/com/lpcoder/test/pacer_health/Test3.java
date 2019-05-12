package com.lpcoder.test.pacer_health;

/**
 * @author liurenpeng
 * @date Created in 19-4-21
 */
public class Test3 {

    public static void main(String[] args) {
        //int[] A = new int[]{2, 8, 4, 3, 2};
        int[] A = new int[]{1000, 8, 4, 3, 2};
        System.out.println(solution(A, 7, 11, 3));
    }

    public static int solution(int[] A, int X, int Y, int Z) {
        // write your code in Java SE 8
        int time = 0;
        int[] dispenser = new int[]{X, Y, Z};
        int[] using = new int[]{0, 0, 0};
        for (int i = 0; i < A.length; ) {
            boolean changed = tFuel(A[i], dispenser, using);
            if (changed) {
                i ++;
                continue;
            }
            if (using[0] == 0 && using[1] == 0 && using[2] == 0) {
                return -1;
            }
            time += countDown(dispenser, using);
        }
        return time;
    }

    public static boolean tFuel(int num, int[] dispenser, int[] using) {
        for (int i = 0; i < 3; i++) {
            if (dispenser[i] >= num && using[i] == 0) {
                //dispenser[i] -= num;
                using[i] = num;
                return true;
            }
        }
        return false;
    }

    public static int countDown(int[] dispenser, int[] using) {
        int min;
        if (using[0] > 0) {
            min = using[0];
        } else if (using[1] > 0) {
            min = using[1];
        } else {
            min = using[2];
        }

        for (int i = 0; i < 3; i++) {
            if (using[i] == 0) {
                continue;
            }
            min = Math.min(min, dispenser[i]);
        }

        for (int i = 0; i < 3; i++) {
            if (using[i] == 0) {
                continue;
            }
            using[i] = using[i] - min;
            dispenser[i] = dispenser[i] - min;
        }
        return min;
    }


}
