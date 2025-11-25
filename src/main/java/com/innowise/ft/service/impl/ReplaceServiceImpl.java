package com.innowise.ft.service.impl;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;
import com.innowise.ft.service.ReplaceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplaceServiceImpl implements ReplaceService {
    private static final Logger logger = LogManager.getLogger();
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
