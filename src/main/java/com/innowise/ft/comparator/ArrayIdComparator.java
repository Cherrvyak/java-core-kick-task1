package com.innowise.ft.comparator;

import com.innowise.ft.entity.IntArray;
import java.util.Comparator;

public class ArrayIdComparator implements Comparator<IntArray> {

  @Override
  public int compare(IntArray o1, IntArray o2) {
    return Long.compare(o1.getId(), o2.getId());
  }
}