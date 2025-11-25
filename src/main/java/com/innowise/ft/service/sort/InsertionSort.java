package com.innowise.ft.service.sort;

import com.innowise.ft.entity.IntArray;

public class InsertionSort implements ArraySortService {
    @Override
    public void sort(IntArray intArray) {
        if (intArray == null || intArray.getArray().length < 2) {
            return;
        }

        int[] array = intArray.getArray();
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int currentElement = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > currentElement) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = currentElement;
        }
    }

}
