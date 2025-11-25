package com.innowise.ft.service.sort;

import com.innowise.ft.entity.IntArray;

public class BubbleSort implements ArraySortService {
    @Override
    public void sort(IntArray intArray) {
        if (intArray == null || intArray.getArray().length < 2) {
            return;
        }

        int[] array = intArray.getArray();
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}
