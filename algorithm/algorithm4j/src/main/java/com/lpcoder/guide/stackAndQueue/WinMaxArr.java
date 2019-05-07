package com.lpcoder.guide.stackAndQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javafx.util.Pair;

/**
 * @author liurenpeng
 * @date Created in 19-2-14
 */
public class WinMaxArr {

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 5, 4, 3, 3, 6, 7};

        int w = 3;
        Arrays.asList(getWinMaxArr(arr, w)).forEach(System.out::println);
        System.out.println("---");

        int[] arr2 = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] rst = getMaxWindow(arr2, w);
        for (int i = 0; i < rst.length; i++) {
            System.out.println(rst[i]);
        }
    }

    public static Integer[] getWinMaxArr(Integer[] arr, int w) {
        List<Integer> list = Arrays.asList(arr);
        return getIntervals(arr, w).stream()
                .map(pair -> list.subList(pair.getKey(), pair.getValue() + 1))
                .map(subList -> subList.stream().max(Integer::compareTo)
                        .orElseThrow(() -> new RuntimeException("cannot found max value")))
                .toArray(Integer[]::new);
    }

    public static List<Pair<Integer, Integer>> getIntervals(Integer[] arr, int w) {
        if (w < 1) {
            throw new RuntimeException("w must gt 1");
        }
        if (arr.length == 0) {
            return Collections.emptyList();
        }
        if (arr.length <= w) {
            return new LinkedList<Pair<Integer, Integer>>() {{
                add(new Pair<>(1, arr.length - 1));
            }};
        }
        List<Pair<Integer, Integer>> rst = new LinkedList<>();
        int min = 0;
        int max = w + min - 1;
        while (max <= arr.length - 1) {
            rst.add(new Pair<>(min, max));

            min++;
            max = w + min - 1;
        }
        return rst;
    }

    /**
     * 另一种解法
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
