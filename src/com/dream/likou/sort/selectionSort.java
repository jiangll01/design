package com.dream.likou.sort;

/**
 * @author jiangll01
 * @Date: 2021/1/10 20:37
 * @Description: 选择排序
 */
public class selectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,7,5};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static int[] selectionSort(int[] array) {
        if (array.length == 0){
            return array;
        }
        for (int i = 0;i< array.length;i++){
            int min = array[i],index=i;
            for (int j = i+1;j<array.length;j++){
                if (min>array[j]){
                    min = array[j];
                    index = j;
                }
            }
            if (i!=index){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        return array;
    }
}
