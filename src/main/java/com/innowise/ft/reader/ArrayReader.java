package com.innowise.ft.reader;

import com.innowise.ft.exception.ArrayException;
import java.util.List;

public interface ArrayReader {
  List<String> readLines(String fileName) throws ArrayException;
}
