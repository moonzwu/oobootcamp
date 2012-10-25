package org.tw.oobootcamp;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

public class RandomNumberSelectorTest {
    @Test
    public void should_show_an_available_number() {
        List<Integer> integers = asList(1, 2, 3, 4, 5);
        RandomNumberSelector randomNumberSelector = new RandomNumberSelector(integers);
        assertTrue(integers.contains(randomNumberSelector.showNextAvailableNumber()));
    }
}
