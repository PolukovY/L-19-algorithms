package com.levik.bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchTimeTest {

    @Test
    public void calcBstTime() {
        RecursiveBinarySearchTree<Integer> bst = new RecursiveBinarySearchTree<>();

        int limit = 10_000_000;

        for(int index = 0; index < limit; index++) {
            int val = ThreadLocalRandom.current().nextInt();
            bst.insert(val);
        }

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            int val = ThreadLocalRandom.current().nextInt(limit);
            System.out.println("contains ("  + val + ") ->"+ bst.contains(val) + " time " + (System.nanoTime() - start) / 1000 );
        }
    }

    @Test
    public void calcListTime() {
        List<Integer> bst = new ArrayList<>();

        int limit = 10_000_000;

        for(int index = 0; index < limit; index++) {
            int val = ThreadLocalRandom.current().nextInt();
            bst.add(val);
        }

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            int val = ThreadLocalRandom.current().nextInt(limit);
            System.out.println("contains ("  + val + ") ->"+ bst.contains(val) + " time " + (System.nanoTime() - start) / 1000 );
        }
    }
}
