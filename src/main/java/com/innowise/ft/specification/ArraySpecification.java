package com.innowise.ft.specification;

import com.innowise.ft.entity.IntArray;

@FunctionalInterface
public interface ArraySpecification {
  boolean specify(IntArray array);
}