package com.innowise.ft.service;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayServiceImpl implements ArrayService {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public int findMinValue(IntArray array) throws ArrayException {
        logger.info("Finding min for array: {}", array);
        if (array == null || array.getArray() == null || array.getArray().length == 0) {
            throw new ArrayException("Array cannot be null or empty");
        }

        int[] data = array.getArray();
        int min = data[0];

        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }

        logger.info("Sum found: {}", min);

        return min;
    }

    @Override
    public int findMaxValue(IntArray array) throws ArrayException {
        logger.info("Finding max for array: {}", array);
        if (array == null || array.getArray() == null || array.getArray().length == 0) {
            throw new ArrayException("Array cannot be null or empty");
        }

        int[] data = array.getArray();
        int max = data[0];

        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        logger.info("Sum found: {}", max);

        return max;
    }

    @Override
    public int findSum(IntArray array) throws ArrayException {
        logger.info("Finding sum for array: {}", array);
        if (array == null || array.getArray() == null || array.getArray().length == 0) {
            throw new ArrayException("Array is null or empty");
        }

        int[] data = array.getArray();
        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        logger.info("Sum found: {}", sum);

        return sum;
    }

    @Override
    public int countPositiveElements(IntArray array) throws ArrayException {
        logger.info("Finding count of positive elements for array: {}", array);
        if (array == null || array.getArray() == null || array.getArray().length == 0) {
            throw new ArrayException("Array cannot be null or empty");
        }

        int[] data = array.getArray();
        int count = 0;

        for (int value : data) {
            if (value > 0) {
                count++;
            }
        }

        logger.info("Sum found: {}", count);

        return count;
    }

    @Override
    public int countNegativeElements(IntArray array) throws ArrayException {
        logger.info("Finding count of negative elements for array: {}", array);
        if (array == null || array.getArray() == null || array.getArray().length == 0) {
            throw new ArrayException("Array cannot be null or empty");
        }

        int[] data = array.getArray();
        int count = 0;

        for (int value : data) {
            if (value < 0) {
                count++;
            }
        }

        logger.info("Sum found: {}", count);

        return count;
    }

    @Override
    public double findAverage(IntArray array) throws ArrayException {
        logger.info("Finding average for array: {}", array);
        if (array == null || array.getArray() == null || array.getArray().length == 0) {
            throw new ArrayException("Array cannot be null or empty");
        }

        int sum = findSum(array);
        double average = (double) sum / array.getArray().length;

        logger.info("Sum found: {}", sum);

        return average;
    }

    @Override
    public void replaceElements(IntArray array, int oldValue, int newValue) throws ArrayException {
        logger.info("Replacing elements: {} -> {} in array: {}", oldValue, newValue, array);

        if (array == null || array.getLength() == 0) {
            logger.error("Array is null or empty");
            throw new ArrayException("Array cannot be null or empty");
        }

        int[] data = array.getArray();
        boolean replaced = false;
        int replacementCount = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == oldValue) {
                data[i] = newValue;
                replaced = true;
                replacementCount++;
            }
        }

        if (replaced) {
            array.setArray(data);
            logger.info("Replaced {} elements successfully", replacementCount);
        } else {
            logger.info("No elements found to replace. Value {} not found in array", oldValue);
        }
    }

}
