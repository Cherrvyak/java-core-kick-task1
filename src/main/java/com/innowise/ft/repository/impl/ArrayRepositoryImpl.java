package com.innowise.ft.repository.impl;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.repository.ArrayRepository;
import com.innowise.ft.specification.ArraySpecification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ArrayRepositoryImpl implements ArrayRepository {

  private static final Logger logger = LogManager.getLogger();
  private static ArrayRepositoryImpl instance;

  private final Map<Long, IntArray> arrays;

  private ArrayRepositoryImpl() {
    this.arrays = new HashMap<>();
  }

  public static ArrayRepositoryImpl getInstance() {
    if (instance == null) {
      instance = new ArrayRepositoryImpl();
    }
    return instance;
  }

  @Override
  public boolean add(IntArray array) {
    if (array == null || arrays.containsKey(array.getId())) {
      logger.warn("Attempt to add null or duplicate array with ID: {}", array != null ? array.getId() : "null");
      return false;
    }
    arrays.put(array.getId(), array);
    logger.info("Array with ID {} added to repository.", array.getId());
    return true;
  }

  @Override
  public boolean remove(IntArray array) {
    if (array == null) {
      return false;
    }
    return remove(array.getId());
  }

  @Override
  public boolean remove(long id) {
    if (arrays.remove(id) != null) {
      logger.info("Array with ID {} removed from repository.", id);
      return true;
    }
    return false;
  }

  @Override
  public IntArray findById(long id) {
    return arrays.get(id);
  }

  @Override
  public List<IntArray> findAll() {
    return new ArrayList<>(arrays.values());
  }

  @Override
  public List<IntArray> sort(Comparator<IntArray> comparator) {
    return arrays.values().stream()
      .sorted(comparator)
      .collect(Collectors.toList());
  }

  @Override
  public List<IntArray> query(ArraySpecification specification) {
    return arrays.values().stream()
      .filter(specification::specify)
      .collect(Collectors.toList());
  }
}