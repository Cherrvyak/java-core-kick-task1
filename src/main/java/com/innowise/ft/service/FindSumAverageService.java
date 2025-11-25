package com.innowise.ft.service;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;

public interface FindSumAverageService {
  int findSum(IntArray array) throws ArrayException;

  double findAverage(IntArray array) throws ArrayException;
}
