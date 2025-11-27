package com.innowise.ft.comparator;

import com.innowise.ft.entity.IntArray;
import java.util.Comparator;

public class ArrayElementCountComparator implements Comparator<IntArray> {

  @Override
  public int compare(IntArray o1, IntArray o2) {
    return Integer.compare(o1.getData().length, o2.getData().length);
  }
}