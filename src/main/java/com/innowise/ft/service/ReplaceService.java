package com.innowise.ft.service;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;

public interface ReplaceService {
  void replaceElements(IntArray array, int oldValue, int newValue) throws ArrayException;
}
