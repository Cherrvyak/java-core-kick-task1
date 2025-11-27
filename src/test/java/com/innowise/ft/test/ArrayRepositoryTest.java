package com.innowise.ft.test;

import com.innowise.ft.entity.IntArray;
import com.innowise.ft.repository.ArrayRepository;
import com.innowise.ft.repository.impl.ArrayRepositoryImpl;
import com.innowise.ft.specification.ArraySpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayRepositoryTest {

  private static final IntArray ARRAY_1 = new IntArray.Builder().setId(1L).setData(new int[]{1, 1}).build();
  private static final IntArray ARRAY_2 = new IntArray.Builder().setId(2L).setData(new int[]{2, 2, 2}).build();
  private ArrayRepository repository;

  @BeforeEach
  void setUp() {
    repository = ArrayRepositoryImpl.getInstance();
    repository.findAll().forEach(repository::remove);
    repository.add(ARRAY_1);
    repository.add(ARRAY_2);
  }

  @Test
  void getInstanceShouldReturnSingletonInstance() {
    ArrayRepository expected = ArrayRepositoryImpl.getInstance();

    ArrayRepository actual = ArrayRepositoryImpl.getInstance();

    assertNotNull(expected);
    assertSame(expected, actual);
  }

  @Test
  void addShouldReturnTrueOnSuccessfulAddition() {

    IntArray array3 = new IntArray.Builder().setId(3L).setData(new int[]{3}).build();

    boolean isAdded = repository.add(array3);
    IntArray foundArray = repository.findById(3L);

    assertTrue(isAdded);
    assertNotNull(foundArray);
    assertEquals(3, repository.findAll().size());
  }

  @Test
  void removeByIdShouldRemoveArray() {
    long idToRemove = ARRAY_1.getId();

    boolean isRemoved = repository.remove(idToRemove);
    IntArray notFoundArray = repository.findById(idToRemove);

    assertTrue(isRemoved);
    assertNull(notFoundArray);
  }

  @Test
  void queryShouldReturnFilteredList() {
    ArraySpecification twoElementsSpec = array -> array.getData().length == 2;

    List<IntArray> result = repository.query(twoElementsSpec);

    assertEquals(1, result.size());
    assertEquals(ARRAY_1.getId(), result.get(0).getId());
  }
}