package com.innowise.ft.service;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;

public interface FindMaxMinService {
  int findMinValue(IntArray array) throws ArrayException;

  int findMaxValue(IntArray array) throws ArrayException;
}
