package edu.cscc;

import java.util.Arrays;

/**
 * Perform a series of functions to search and sort the data
 * @author Bobby Linse
 * Date: November 2019
 */
public class Functions {

    /**
     * Given an array of int values, the mergeSort
     * function will split the arrays into two,
     * sort the two arrays, and combine them together.
     * @param fullArr
     * @return
     */
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


    /**
     * Given an int[], recursively search for the key-value
     * @param data
     * @param key
     * @return
     */
    public static int rBinarySearch(int[] data, int key){

        int leftSide = 0;
        int rightSide = data.length - 1;
        if (rightSide >= leftSide) {

            int mid = leftSide + (rightSide - leftSide) / 2;

            //Base Case
            if (data[mid] == key || data[mid-1] == key) {
        //        System.out.println("Found key! "+ key);
                return mid;
            }

            if (data[mid] > key) {
        //        System.out.println("Ignoring larger half!");
        //        System.out.println("Data (Recursive): "+ Arrays.toString(data));
                data = splitArrays(data, leftSide, mid);
                return rBinarySearch(data, key);
            }

        //        System.out.println("Ignoring lower half!");
        //        System.out.println("Data (Recursive): "+ Arrays.toString(data));
                data = splitArrays(data, mid + 1, rightSide);
                return rBinarySearch(data, key);

        }
        return -1;
    }

    /**
     * Given an array and a key to search for, perform a binary
     * search to locate the key
     * @param data
     * @param key
     * @return
     */
    public static int iBinarySearch(int[] data, int key){

        int leftSide= 0;
        int rightSide = data.length - 1;

        System.out.println("Data: "+Arrays.toString(data));

        while (leftSide <= rightSide) {

            int m = leftSide + (rightSide - leftSide) / 2;


            if (data[m] == key) {
            //    System.out.println("Found key! "+m);
                return m;
            }

            if (data[m] < key) {
            //    System.out.println("Ignoring lower half!");
                leftSide = m + 1;
            }

            else {
            //   System.out.println("Ignoring larger half!");
                rightSide = m - 1;
            }
        }

        System.out.println("Key not found");
        return -1;
    }

    /**
     * Given two arrays, the mergeArrays function will combine the two
     * into one.
     * @param leftArr
     * @param rightArr
     * @return
     */
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

    /**
     * Given an int[] split it into 2. This is to be used in the recursive
     * binary search
     * @param data
     * @param startPoint
     * @param midPoint
     * @return
     */
    public static int[] splitArrays(int[] data, int startPoint, int midPoint) {

        int[] dataSubarray = new int[midPoint-startPoint+1];

    //    System.out.println("Data: "+ Arrays.toString(data));
    //    System.out.println("Starting position (startPoint): "+ startPoint + "th pos = " + data[startPoint]);
    //    System.out.println("Stopping position (midpoint): "+ midPoint + "th pos = " + data[midPoint]);

        System.arraycopy(data, startPoint, dataSubarray, startPoint, dataSubarray.length);

    //    System.out.println("DataSubarray: "+ Arrays.toString(dataSubarray));
    //    System.out.println("");
        return dataSubarray;
    }

}
