package com.lpcoder.sort;

import static com.lpcoder.CommonUtil.subOne;
import static com.lpcoder.CommonUtil.swap;

/**
 * 堆排序
 *
 * @author liurenpeng
 * @date Created in 19-5-8
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i > 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length; i > 1; i--) {
            swap(arr, subOne(1), subOne(i));
            adjustHeap(arr, 1, i - 1);
        }
    }

    private static void adjustHeap(int[] arr, int s, int m) {
        int temp, j;
        temp = arr[subOne(s)];
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && arr[subOne(j)] < arr[subOne(j + 1)]) {
                j++;
            }
            if (temp >= arr[subOne(j)]) {
                break;
            }
            arr[subOne(s)] = arr[subOne(j)];
            s = j;
        }
        arr[subOne(s)] = temp;
    }

}
