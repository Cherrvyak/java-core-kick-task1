package com.innowise.ft.warehouse;

public class ArrayMetrics {
  private int sum;
  private double average;
  private int min;
  private int max;

  public ArrayMetrics(int sum, double average, int min, int max) {
    this.sum = sum;
    this.average = average;
    this.min = min;
    this.max = max;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public double getAverage() {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }
}