package com.innowise.ft.entity;

import com.innowise.ft.observer.ArrayObservable;
import com.innowise.ft.observer.ArrayObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntArray implements ArrayObservable {

    private long id;
    private int[] data;
    private List<ArrayObserver> observers = new ArrayList<>();

    private IntArray(long id, int[] data) {
        this.id = id;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public int[] getData() {
        return Arrays.copyOf(data, data.length);
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < data.length) {
            this.data[index] = value;
            notifyObservers();
        }
    }

    public void setData(int[] data) {
        this.data = data;
        notifyObservers();
    }

    @Override
    public void attach(ArrayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ArrayObserver observer : observers) {
            observer.handleEvent(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray intArray = (IntArray) o;
        return id == intArray.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "IntArray{" +
          "id=" + id +
          ", data=" + Arrays.toString(data) +
          '}';
    }

    public static class Builder {
        private long id;
        private int[] data;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setData(int[] data) {
            this.data = data;
            return this;
        }

        public IntArray build() {
            return new IntArray(id, data);
        }
    }
}
