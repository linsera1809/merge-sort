package edu.cscc;

import java.util.Arrays;

public class Functions {

    public static int[] mergeSort(int[] fullArr) {
        int size = fullArr.length;
        int[] leftArr = new int[size/2];
        int[] rightArr = new int[size - size/2];

        //Base Case
        if (size <= 1){
            return fullArr;
        }

        for (int i = 0; i < leftArr.length; i++){
            leftArr[i] = fullArr[i];
        }

        for (int i = 0; i < rightArr.length; i++){
            rightArr[i] = fullArr[i + size/2];
        }

        return mergeArrays(mergeSort(leftArr), mergeSort(rightArr));
    }


    public static int rBinarySearch(int[] data, int key){

        return -1;
    }

    public static int iBinarySearch(int[] data, int key){

        return -1;
    }

    public static int[] mergeArrays(int[] leftArr, int[] rightArr) {
        int[] fullArr = new int[leftArr.length + rightArr.length];

        int i = 0, j = 0;

        for (int k = 0; k < fullArr.length; k++) {
            if(i >= leftArr.length) {
                fullArr[k] = rightArr[j++];
            }

            else if(j >= rightArr.length) {
                fullArr[k] = leftArr[i++];
            }

            else if(leftArr[i] <= rightArr[j]) {
                fullArr[k] = leftArr[i++];
            }

            else {
                fullArr[k] = rightArr[j++];
            }
        }

        return fullArr;
    }

}
