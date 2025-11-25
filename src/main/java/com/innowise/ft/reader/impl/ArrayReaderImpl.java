package com.innowise.ft.reader.impl;

import com.innowise.ft.reader.ArrayReader;
import com.innowise.ft.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayReaderImpl implements ArrayReader {

  private static final Logger logger = LogManager.getLogger();

  private static final String RESOURCE_DIR = "data/";

  @Override
  public List<String> readLines(String fileName) throws ArrayException {
    URL resourceUrl = getClass().getClassLoader().getResource(RESOURCE_DIR + fileName);

    if (resourceUrl == null) {
      logger.error("File not found in resources: {}", RESOURCE_DIR + fileName);
      throw new ArrayException("File not found: " + fileName);
    }

    Path path = null;
    try {
      path = Paths.get(resourceUrl.toURI());

    } catch (Exception e) {
      logger.error("Error converting URL to Path for file: {}", fileName, e);
      throw new ArrayException("Invalid file path: " + fileName, e);
    }

    logger.info("Attempting to read file: {}", path);

    try {
      List<String> lines = Files.lines(path)
        .collect(Collectors.toList());

      logger.info("Successfully read {} lines from file: {}", lines.size(), fileName);
      return lines;

    } catch (IOException e) {
      logger.error("IO error while reading file: {}", fileName, e);
      throw new ArrayException("Error reading file: " + fileName, e);
    }
  }
}