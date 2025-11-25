package com.innowise.ft.service;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;

public interface FindCountPosNegService {
  int countPositiveElements(IntArray array) throws ArrayException;

  int countNegativeElements(IntArray array) throws ArrayException;
}
