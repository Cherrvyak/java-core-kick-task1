package com.innowise.ft.service.impl;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;
import com.innowise.ft.service.FindMaxMinService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindMaxMinServiceImpl implements FindMaxMinService {
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
}
