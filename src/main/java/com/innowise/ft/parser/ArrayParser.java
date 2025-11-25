package com.innowise.ft.parser;

import com.innowise.ft.exception.ArrayException;

// Интерфейс для преобразования строки в массив чисел
public interface ArrayParser {

  int[] parseLine(String line) throws ArrayException;
}