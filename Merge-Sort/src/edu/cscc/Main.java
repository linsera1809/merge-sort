package edu.cscc;


import java.util.Arrays;

public class Main {
  public static void main(String[] args){
            int[] a = {1,3,5,7,9,2,4,6,8,11};
            System.out.println(Arrays.toString(a));
            a = Functions.mergeSort(a);
            System.out.println(Arrays.toString(a));

            int idx = Functions.rBinarySearch(a,4);
        }
    }
