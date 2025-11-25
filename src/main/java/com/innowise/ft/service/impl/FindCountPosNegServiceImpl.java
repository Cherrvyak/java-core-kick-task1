package com.innowise.ft.service.impl;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;
import com.innowise.ft.service.FindCountPosNegService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindCountPosNegServiceImpl implements FindCountPosNegService {
    private static final Logger logger = LogManager.getLogger();

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

}
