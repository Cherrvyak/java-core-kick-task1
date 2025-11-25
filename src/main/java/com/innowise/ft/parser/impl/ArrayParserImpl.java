package com.innowise.ft.parser.impl;

import com.innowise.ft.parser.ArrayParser;
import com.innowise.ft.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayParserImpl implements ArrayParser {

  private static final Logger logger = LogManager.getLogger();

  private static final String DELIMITER_REGEX = "[ ,;-]+";

  @Override
  public int[] parseLine(String line) throws ArrayException {

    logger.info("Parsing line into an array: {}", line);

    try {
      String[] stringNumbers = line.trim().split(DELIMITER_REGEX);

      int[] intArray = Arrays.stream(stringNumbers)
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .mapToInt(Integer::parseInt)
        .toArray();

      logger.info("Successfully parsed array with {} elements.", intArray.length);
      return intArray;

    } catch (NumberFormatException e) {
      logger.error("Error parsing string to number: {}", line, e);
      throw new ArrayException("Failed to parse array elements from line: " + line, e);
    }
  }
}