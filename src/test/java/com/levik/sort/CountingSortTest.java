package com.levik.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    @Test
    public void shouldTestCountingSort () {
        //given
        int [] array = {3, 1, 7, 2, 2, 0};
        int max = 7;
        int[] expected = {0, 1, 2, 2, 3, 7};

        //when
        int[] sortedArray = CountingSort.countingSort(array, max);

        //then
        assertArrayEquals(expected, sortedArray);
    }
}