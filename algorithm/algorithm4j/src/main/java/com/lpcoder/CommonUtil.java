package com.lpcoder;

/**
 * @author liurenpeng
 * @date Created in 19-5-8
 */
public class CommonUtil {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static int subOne(int i) {
        return i - 1;
    }

}
