package com.innowise.ft.test;

import com.innowise.ft.comparator.ArrayIdComparator;
import com.innowise.ft.entity.IntArray;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayIdComparatorTest {

  private static final IntArray SMALLER_ID = new IntArray.Builder().setId(10L).setData(new int[]{1}).build();
  private static final IntArray LARGER_ID = new IntArray.Builder().setId(20L).setData(new int[]{2}).build();
  private static final IntArray EQUAL_ID = new IntArray.Builder().setId(10L).setData(new int[]{3}).build();

  private final Comparator<IntArray> comparator = new ArrayIdComparator();

  @Test
  void compareShouldReturnNegativeIfFirstIdIsSmaller() {

    int result = comparator.compare(SMALLER_ID, LARGER_ID);

    assertTrue(result < 0);
  }

  @Test
  void compareShouldReturnPositiveIfFirstIdIsLarger() {

    int result = comparator.compare(LARGER_ID, SMALLER_ID);

    assertTrue(result > 0);
  }

  @Test
  void compareShouldReturnZeroIfIdsAreEqual() {

    int result = comparator.compare(SMALLER_ID, EQUAL_ID);
    
  }
}