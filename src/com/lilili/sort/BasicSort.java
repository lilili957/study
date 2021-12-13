package com.lilili.sort;

import java.util.Arrays;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class BasicSort {

//    public static void bubbleSort(Integer[] arr) {
//        if (arr.length < 2) {
//            return;
//        }
//        int len = arr.length;
//        for (int i = len; i > 0; i--) {
//            for (int j = 0; j < i - 1; j++) {
//                if (greater(arr[j], arr[j + 1])) {
//                    swap(arr, j, j + 1);
//                }
//            }
//        }
//    }

    public static void bubbleSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = len; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (greater(arr[j], arr[j + 1])) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (greater(arr[minIndex], arr[j])) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    public static void insertSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(arr[j - 1], arr[j])) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean greater(Integer i, Integer j) {
        return i.compareTo(j) > 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {29, 8, 6, 5, 4, 3, 1, 453, 7, 659, 987};
        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
