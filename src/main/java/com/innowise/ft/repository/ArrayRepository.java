package com.innowise.ft.repository;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
  boolean add(IntArray array);
  boolean remove(IntArray array);
  boolean remove(long id);
  IntArray findById(long id);
  List<IntArray> findAll();
  List<IntArray> sort(Comparator<IntArray> comparator);
  List<IntArray> query(ArraySpecification specification);
}