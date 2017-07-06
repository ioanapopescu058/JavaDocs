package com.java_8_training.problems.collectors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore
public class CollectTest {

    private List<Integer> numbers;

    @Before
    public void setUp() {
        numbers = Arrays.asList(2, 4, 1, 2, 4, 9);
    }

    @Test
    public void noDuplicatedWithStreams() {
        List<Integer> noDuplicates = new ArrayList<>();
        //TODO #C3
        noDuplicates = numbers.stream().distinct().collect(Collectors.toList());
        assertThat(noDuplicates, is(Arrays.asList(2, 4, 1, 9)));
    }

    @Test
    public void noDuplicatesWithCollector() {
        Set<Integer> noDuplicates = new HashSet<>();
        //TODO #C3
        noDuplicates = numbers.stream().collect(Collectors.toSet());
        Set<Integer> expected = new HashSet<>(Arrays.asList(2, 4, 1, 9));
        assertThat(noDuplicates, is(expected));
    }

    @Test
    public void streamToTreeSet() {
        Set<Integer> noDuplicates = new HashSet<>();
       //TODO #C4

        Set<Integer> expected = new TreeSet<>(Arrays.asList(2, 4, 1, 9));
        noDuplicates = numbers.stream().collect(Collectors.toCollection(TreeSet::new));
        assertThat(noDuplicates, is(expected));
        assertThat(noDuplicates, instanceOf(TreeSet.class));
    }

}
