package com.dream.likou.sort;

/**
 * @author jiangll01
 * @Date: 2021/1/10 20:14
 * @Description: 冒泡算法
 */
public class Bubbling {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,7,5};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] bubbleSort(int[] array) {
        if (array.length == 1||array.length==0) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (array[j]<=array[j+1]){
                    break;
                }else {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
