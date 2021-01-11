package com.dream.likou;

/**
 * @author jiangll01
 * @Date: 2020/12/28 11:23
 * @Description:
 */
public class Solution2 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, last = array.length - 1;

        while (low<=last){
            int mid = low+(last-low) / 2;
            if (array[mid]>array[last]){
                if (array[mid]>array[mid+1]){
                    return array[mid+1];
                }
                low = mid+1;
            }else if (array[mid]<array[low]){
                if(array[mid] < array[mid-1])
                    return array[mid];
                last = mid - 1;
            }

        }
        return 0;
    }
}
