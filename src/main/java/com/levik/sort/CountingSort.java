package com.levik.sort;

public class CountingSort {

    public static int[] countingSort(int[] array, int maxValue) {
        int [] counts = new int[maxValue + 1];
        int [] sortedArray = new int[array.length];
        int sortArrayPosition = 0;

        //populate counts array
        for (int val : array) {
            counts[val] += 1;
        }

        //build sortedArray
        for (int index = 0; index < counts.length; index++) {
            int count = counts[index];
            for (int j = 0; j< count; j++) {
                sortedArray[sortArrayPosition++] = index;
            }
        }

        return sortedArray;
    }
}
