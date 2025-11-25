package com.innowise.ft.parser;

import com.innowise.ft.exception.ArrayException;

public interface ArrayParser {

  int[] parseLine(String line) throws ArrayException;
}