package com.innowise.ft.warehouse;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.exception.ArrayException;
import com.innowise.ft.observer.ArrayObserver;
import com.innowise.ft.service.FindMaxMinService;
import com.innowise.ft.service.FindSumAverageService;
import com.innowise.ft.service.impl.FindSumAverageServiceImpl;
import com.innowise.ft.service.impl.FindMaxMinServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements ArrayObserver {

  private static final Logger logger = LogManager.getLogger();
  private static Warehouse instance;

  private final Map<Long, ArrayMetrics> metricsMap;

  private final FindMaxMinService minMaxService;
  private final FindSumAverageService calculationService;

  private Warehouse() {
    this.metricsMap = new HashMap<>();
    this.minMaxService = new FindMaxMinServiceImpl();
    this.calculationService = new FindSumAverageServiceImpl();
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public void putMetrics(long arrayId, ArrayMetrics metrics) {
    metricsMap.put(arrayId, metrics);
    logger.info("Metrics for array ID {} updated in Warehouse.", arrayId);
  }

  public ArrayMetrics getMetrics(long arrayId) {
    return metricsMap.get(arrayId);
  }

  @Override
  public void handleEvent(IntArray changedArray) {
    long id = changedArray.getId();

    try {
      int min = minMaxService.findMinValue(changedArray);
      int max = minMaxService.findMaxValue(changedArray);
      int sum = calculationService.findSum(changedArray);
      double avg = calculationService.findAverage(changedArray);

      ArrayMetrics newMetrics = new ArrayMetrics(sum, avg, min, max);

      putMetrics(id, newMetrics);

    } catch (ArrayException e) {
      logger.error("Error with metrics for array ID: {}", id, e);
    }
  }
}