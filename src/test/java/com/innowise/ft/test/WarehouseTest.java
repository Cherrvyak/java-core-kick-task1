package com.innowise.ft.test;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.warehouse.ArrayMetrics;
import com.innowise.ft.warehouse.Warehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {

  private static final IntArray ARRAY_FOR_TEST = new IntArray.Builder()
    .setId(20L)
    .setData(new int[]{10, 20, 30})
    .build();

  private static final int NEW_VALUE = 100;

  @Test
  void getInstanceShouldReturnSingletonInstance() {
    Warehouse expected = Warehouse.getInstance();

    Warehouse actual = Warehouse.getInstance();

    assertNotNull(expected);
    assertSame(expected, actual);
  }

  @Test
  void handleEventShouldRecalculateMetrics() {
    Warehouse warehouse = Warehouse.getInstance();

    ARRAY_FOR_TEST.attach(warehouse);
    warehouse.handleEvent(ARRAY_FOR_TEST);

    ARRAY_FOR_TEST.setElement(0, NEW_VALUE);

    ArrayMetrics updatedMetrics = warehouse.getMetrics(ARRAY_FOR_TEST.getId());
    assertNotNull(updatedMetrics);

    assertEquals(150, updatedMetrics.getSum());

    assertEquals(100, updatedMetrics.getMax());
  }
}