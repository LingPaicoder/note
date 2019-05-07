package com.lpcoder.sort;

import static com.lpcoder.CommonUtil.swap;

/**
 * 快速排序
 *
 * @author liurenpeng
 * @date Created in 19-5-8
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = new int[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        fastSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void fastSort(int[] arr, int low, int high) {
        int v;
        if (low < high) {
            v = partition(arr, low, high);
            fastSort(arr, low, v - 1);
            fastSort(arr, v + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int vVal = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= vVal) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= vVal) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }



}
