package com.innowise.ft.specification.impl;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.specification.ArraySpecification;
import com.innowise.ft.warehouse.Warehouse;
import com.innowise.ft.warehouse.ArrayMetrics;

public class ArraySumGreaterSpecification implements ArraySpecification {

  private final int targetSum;

  public ArraySumGreaterSpecification(int targetSum) {
    this.targetSum = targetSum;
  }

  @Override
  public boolean specify(IntArray array) {
    Warehouse warehouse = Warehouse.getInstance();
    ArrayMetrics metrics = warehouse.getMetrics(array.getId());

    return metrics != null && metrics.getSum() > targetSum;
  }
}