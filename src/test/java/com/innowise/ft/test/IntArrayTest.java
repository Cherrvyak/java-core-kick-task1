package com.innowise.ft.test;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.observer.ArrayObserver;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntArrayTest {

    private static final int[] INITIAL_DATA = {1, 2, 3};
    private static final int NEW_VALUE = 99;
    private static final int TARGET_INDEX = 1;

    private static class MockObserver implements ArrayObserver {
        private boolean wasNotified = false;

        @Override
        public void handleEvent(IntArray array) {
            wasNotified = true;
        }

        public boolean isWasNotified() {
            return wasNotified;
        }
    }

    @Test
    void setElementShouldChangeValueAndNotifyObserver() {
        IntArray array = new IntArray.Builder()
          .setId(10L)
          .setData(INITIAL_DATA)
          .build();
        MockObserver observer = new MockObserver();
        array.attach(observer);

        array.setElement(TARGET_INDEX, NEW_VALUE);
        int actualValue = array.getData()[TARGET_INDEX];

        assertEquals(NEW_VALUE, actualValue);
        assertTrue(observer.isWasNotified());
    }

    @Test
    void setElementShouldNotChangeValueIfIndexIsInvalid() {
        IntArray array = new IntArray.Builder()
          .setId(11L)
          .setData(INITIAL_DATA)
          .build();
        MockObserver observer = new MockObserver();
        array.attach(observer);

        array.setElement(-1, NEW_VALUE);
        int actualValue = array.getData()[TARGET_INDEX];

        assertEquals(INITIAL_DATA[TARGET_INDEX], actualValue);
        assertTrue(!observer.isWasNotified());
    }
}