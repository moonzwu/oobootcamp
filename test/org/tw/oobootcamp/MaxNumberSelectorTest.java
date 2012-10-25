package org.tw.oobootcamp;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxNumberSelectorTest {
    @Test
    public void should_get_the_max_number() {
        List<Integer> integers = asList(1, 2, 3, 4, 5);
        MaxNumberSelector maxNumberSelector = new MaxNumberSelector(integers);
        assertThat(maxNumberSelector.showNextAvailableNumber(), is(5));
    }
}
