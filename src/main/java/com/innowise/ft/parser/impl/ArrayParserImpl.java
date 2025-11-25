package com.innowise.ft.parser.impl;

import com.innowise.ft.parser.ArrayParser;
import com.innowise.ft.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

// Класс для преобразования строки в массив чисел
public class ArrayParserImpl implements ArrayParser {

  private static final Logger logger = LogManager.getLogger();

  // Требование: Регулярные выражения выносить в константы
  // Регулярное выражение для разделения: любое количество пробелов, запятая,
  // дефис или точка с запятой (в квадратных скобках: [ ,;-]).
  private static final String DELIMITER_REGEX = "[ ,;-]+";

  @Override
  public int[] parseLine(String line) throws ArrayException {
    // Мы предполагаем, что на вход приходит уже валидная строка

    logger.info("Parsing line into an array: {}", line);

    try {
      // 1. Разбиваем строку по всем возможным разделителям
      // Удаляем начальные/конечные пробелы и разбиваем строку.
      String[] stringNumbers = line.trim().split(DELIMITER_REGEX);

      // 2. Преобразуем массив строк в массив целых чисел
      int[] intArray = Arrays.stream(stringNumbers)
        .map(String::trim)        // Удаляем пробелы, если остались
        .filter(s -> !s.isEmpty()) // Отфильтровываем пустые строки, которые могли возникнуть из-за разделителей
        .mapToInt(Integer::parseInt) // Преобразуем каждую строку в int
        .toArray();

      logger.info("Successfully parsed array with {} elements.", intArray.length);
      return intArray;

    } catch (NumberFormatException e) {
      // Если валидатор ошибся или строка содержит что-то непарсибельное (очень маловероятно)
      logger.error("Error parsing string to number: {}", line, e);
      // Генерируем собственное исключение, оборачивая стандартное
      // Примечание: Не генерировать стандартные исключения в публичных методах [cite: 72, 73]
      throw new ArrayException("Failed to parse array elements from line: " + line, e);
    }
  }
}