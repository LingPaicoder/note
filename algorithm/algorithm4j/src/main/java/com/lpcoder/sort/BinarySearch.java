package com.lpcoder.sort;

/**
 * 二分查找/折半查找
 *
 * @author liurenpeng
 * @date Created in 19-5-7
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        System.out.println(binarySearch(arr, 97));
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                return key;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
