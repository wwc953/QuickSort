package com.quicksort;

/**
 * Created by Roll on 2017/10/15.
 * <p>
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {-3, 8, 10, 3, 0, 145, -10};
        sort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void sort(int[] a, int low, int high) {
        int pos;

        if (low < high) {
            pos = findPos(a, low, high);//找到第一个元素的位置
            sort(a, low, pos - 1);//左边排序，
            sort(a, pos + 1, high);//右边排序，
        }
    }

    public static int findPos(int[] a, int low, int high) {
        int val = a[low];

        while (low < high) {//判断条件：确保所有元素都被找过一遍

            //先从high向左找，找到 < val的值，停止寻找，并将当前值赋给a[low]
            while (low < high && a[high] >= val)
                high--;
            a[low] = a[high];

            //high停止后，从low开始向后找，找到 > val 的值，停止寻找，并将当前值赋给a[high]
            while (low < high && a[low] <= val)
                low++;
            a[high] = a[low];
        }

        a[low] = val;//确定了第一个元素的位置

        return low;//low=high
    }


}
