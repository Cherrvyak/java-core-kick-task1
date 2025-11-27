package com.innowise.ft.observer;

public interface ArrayObservable {
  void attach(ArrayObserver observer);
  void detach(ArrayObserver observer);
  void notifyObservers();
}