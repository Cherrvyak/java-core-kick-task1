package com.innowise.ft.service.sort;

import com.innowise.ft.entity.IntArray;

public class SelectionSort implements ArraySortService {
    @Override
    public void sort(IntArray intArray) {
        if (intArray == null || intArray.getArray().length < 2) {
            return;
        }

        int[] array = intArray.getArray();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
