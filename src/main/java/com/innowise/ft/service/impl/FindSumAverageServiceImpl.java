package com.innowise.ft.service.impl;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;
import com.innowise.ft.service.FindSumAverageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindSumAverageServiceImpl implements FindSumAverageService {
    private static final Logger logger = LogManager.getLogger();

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
}
