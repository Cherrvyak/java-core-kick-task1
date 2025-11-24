package com.innowise.ft.test;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;
import com.innowise.ft.service.ArrayService;
import com.innowise.ft.service.ArrayServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ArrayTest {

    private final ArrayService service = new ArrayServiceImpl();

    @Test
    void findSum_ShouldReturnCorrectSum() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{1, 2, 3})
                .build();

        int result = service.findSum(array);

        assertEquals(6, result);
    }

    @Test
    void findSum_ShouldThrowExceptionForEmptyArray() {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{})
                .build();

        assertThrows(ArrayException.class, () -> service.findSum(array));
    }

    @Test
    void findMinValue_ShouldReturnCorrectMin() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{5, -2, 8, 0})
                .build();

        int result = service.findMinValue(array);

        assertEquals(-2, result);
    }

    @Test
    void findMaxValue_ShouldReturnCorrectMax() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{5, -2, 8, 0})
                .build();

        int result = service.findMaxValue(array);

        assertEquals(8, result);
    }

    @Test
    void findAverage_ShouldReturnCorrectAverage() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{1, 2, 3})
                .build();

        double result = service.findAverage(array);

        assertEquals(2.0, result, 0.001);
    }

    @Test
    void countPositiveElements_ShouldReturnCorrectCount() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{5, -2, 8, 0, -1})
                .build();

        int result = service.countPositiveElements(array);

        assertEquals(2, result);
    }

    @Test
    void countNegativeElements_ShouldReturnCorrectCount() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{5, -2, 8, 0, -1})
                .build();

        int result = service.countNegativeElements(array);

        assertEquals(2, result);
    }

    @Test
    void replaceElements_ShouldReplaceValues() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{1, 2, 3, 2})
                .build();

        service.replaceElements(array, 2, 9);

        assertEquals(1, array.getElement(0));
        assertEquals(9, array.getElement(1));
        assertEquals(3, array.getElement(2));
        assertEquals(9, array.getElement(3));
    }

    @Test
    void replaceElements_ShouldNotReplaceWhenValueNotFound() throws ArrayException {
        IntArray array = IntArray.newBuilder()
                .setArray(new int[]{1, 2, 3})
                .build();

        int[] original = array.getArray().clone();
        service.replaceElements(array, 5, 9);

        assertArrayEquals(original, array.getArray());
    }
}