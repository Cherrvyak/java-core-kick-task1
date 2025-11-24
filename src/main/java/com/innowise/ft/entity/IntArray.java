package com.innowise.ft.entity;

import com.innowise.ft.exception.ArrayException;

public class IntArray {
    private int[] array;

    private IntArray() {
    }

    public int[] getArray() {
        return array;
    }

    public static Builder newBuilder() {
        return new IntArray().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setArray(int[] array) {
            IntArray.this.array = array;

            return this;
        }

        public IntArray build() {
            return IntArray.this;
        }

    }

    public void setArray(int[] array) {
        this.array = array != null ? array.clone() : new int[0];
    }

    public int getLength() {
        return array != null ? array.length : 0;
    }

    public int getElement(int index) throws ArrayException {
        if (array == null || index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " out of bounds");
        }
        return array[index];
    }

    public void setElement(int index, int value) throws ArrayException {
        if (array == null || index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " out of bounds");
        }
        array[index] = value;
    }

}
