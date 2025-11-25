package com.innowise.ft.validator.impl;

import com.innowise.ft.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {

  private static final Logger logger = LogManager.getLogger();

  private static final String ARRAY_LINE_REGEX = "^[\\d,\\s\\-;]+$";

  @Override
  public boolean isValidLine(String line) {
    if (line == null || line.isBlank()) {
      return false;
    }

    boolean isValid = line.trim().matches(ARRAY_LINE_REGEX);

    if (isValid) {
      logger.debug("Line is valid: {}", line);
    } else {
      logger.debug("Line is invalid and will be skipped: {}", line);
    }

    return isValid;
  }
}