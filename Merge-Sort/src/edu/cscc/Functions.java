package edu.cscc;

import java.util.Arrays;

public class Functions {

    public static int[] mergeSort(int[] a) {

        int size = a.length;

        //base case
        if(size == 1){
            return a;
        }
        else {
            int[] leftArr = new int[(size+1)/2];
            int[] rightArr = new int[size - leftArr.length];

            for (int i = 0; i < size; i++)
            {
                if (i < leftArr.length)
                    leftArr[i] = a[i];
                else
                    rightArr[i - leftArr.length] = a[i];
            }

            System.out.println("Complete: "+Arrays.toString(a));
            System.out.println("Left: "+Arrays.toString(leftArr));
            System.out.println("Right: "+Arrays.toString(rightArr));

            return a;

        }

    }

    public static int rBinarySearch(int[] data, int key){

        return -1;
    }

    public static int iBinarySearch(int[] data, int key){

        return -1;
    }

}
